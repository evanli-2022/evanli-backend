package ru.evanli.moretech.wallets.service;

import io.jsonwebtoken.lang.Collections;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.evanli.moretech.wallets.domain.Wallet;
import ru.evanli.moretech.wallets.domain.dto.WalletDto;
import ru.evanli.moretech.wallets.domain.remote.wallet.WalletKeysResponse;
import ru.evanli.moretech.wallets.repository.WalletRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WalletService {

    private static final String PRIVATE_WALLET_TITLE = "Личный кошелёк";

    private final WalletRepository walletRepository;
    private final RemoteWalletApiService remoteWalletApiService;

    @Value("${wallet.api.defaultPublicKey}")
    private final String defaultPublicKey;

    @Value("${wallet.api.defaultPrivateKey}")
    private final String defaultPrivateKey;

    @Transactional
    public List<WalletDto> getByUserId(Long userId) {
        List<Wallet> wallets = walletRepository.findByUserId(userId);

        if (Collections.isEmpty(wallets)) {
            wallets = createWallet(userId);
        }

        for (Wallet wallet : wallets) {
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

        return wallets.stream().map(
            w -> WalletDto.builder()
                .id(w.getId())
                .userId(w.getUserId())
                .kind(w.getKind())
                .title(w.getTitle())
                .balance(remoteWalletApiService.getBalance(w.getPublicKey()))
                .build()
        ).toList();
    }

    private List<Wallet> createWallet(Long userId) {
        Wallet wallet = Wallet.builder()
            .userId(userId)
            .kind(Wallet.WalletType.PRIVATE)
            .title(PRIVATE_WALLET_TITLE)
            .build();

        wallet = walletRepository.save(wallet);

        return List.of(wallet);
    }
}
