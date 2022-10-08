package ru.evanli.moretech.wallets.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.evanli.moretech.wallets.domain.Transaction;
import ru.evanli.moretech.wallets.domain.UserDetailsImpl;
import ru.evanli.moretech.wallets.domain.Wallet;
import ru.evanli.moretech.wallets.domain.dto.TransferData;
import ru.evanli.moretech.wallets.domain.dto.WalletDto;
import ru.evanli.moretech.wallets.domain.remote.wallet.TransferRequest;
import ru.evanli.moretech.wallets.domain.remote.wallet.TransferResponse;
import ru.evanli.moretech.wallets.domain.remote.wallet.WalletKeysResponse;
import ru.evanli.moretech.wallets.repository.WalletRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class WalletService {

    private static final String PRIVATE_WALLET_TITLE = "Личный кошелёк";

    private final WalletRepository walletRepository;
    private final RemoteWalletApiService remoteWalletApiService;
    private final TransactionService transactionService;

    @Value("${wallet.api.defaultPublicKey}")
    private final String defaultPublicKey;

    @Value("${wallet.api.defaultPrivateKey}")
    private final String defaultPrivateKey;

    @Transactional
    public WalletDto getWalletDtoByUserId(Long userId) {
        Wallet wallet = getWalletByUserId(userId);

        return buildWalletWithBalance(wallet);
    }

    @Transactional
    public Transaction transfer(TransferData transferData) {

        UserDetailsImpl userDetails =
            (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Wallet from = getWalletByUserId(userDetails.getId());

        Wallet to = getWalletByUserId(transferData.getToUserId());

        TransferResponse response = remoteWalletApiService.transfer(
            TransferRequest.builder()
                .fromPrivateKey(from.getPrivateKey())
                .toPrivateKey(to.getPublicKey())
                .amount(transferData.getAmount())
                .build()
        );

        log.info("Transaction {} requested", response.getTransaction());

        return transactionService.save(
            Transaction.builder()
                .fromUserId(userDetails.getId())
                .toUserId(transferData.getToUserId())
                .amount(transferData.getAmount())
                .hash(response.getTransaction())
                .comment(transferData.getComment())
                .build()
        );
    }

    private Wallet getWalletByUserId(Long userId) {
        Wallet wallet = walletRepository.getTopByUserId(userId);

        if (wallet == null) {
            wallet = createWallet(userId);
        }

        createKeysInNotExist(wallet);

        return wallet;
    }

    private void createKeysInNotExist(Wallet wallet) {
        if (StringUtils.isEmpty(wallet.getPublicKey())) {
            if (wallet.getUserId() == 1L && Wallet.WalletType.CORPORATE.equals(wallet.getKind())) {
                wallet.setPublicKey(defaultPublicKey);
                wallet.setPrivateKey(defaultPrivateKey);
            } else {
                WalletKeysResponse keys = remoteWalletApiService.createWallet();
                wallet.setPublicKey(keys.getPublicKey());
                wallet.setPrivateKey(keys.getPrivateKey());
            }
            walletRepository.save(wallet);
        }
    }

    private WalletDto buildWalletWithBalance(Wallet w) {
        return WalletDto.builder()
            .id(w.getId())
            .userId(w.getUserId())
            .kind(w.getKind())
            .title(w.getTitle())
            .balance(remoteWalletApiService.getBalance(w.getPublicKey()))
            .build();
    }

    private Wallet createWallet(Long userId) {
        Wallet wallet = Wallet.builder()
            .userId(userId)
            .kind(Wallet.WalletType.PRIVATE)
            .title(PRIVATE_WALLET_TITLE)
            .build();

        return walletRepository.save(wallet);
    }
}
