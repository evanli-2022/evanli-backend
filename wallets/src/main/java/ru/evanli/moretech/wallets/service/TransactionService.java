package ru.evanli.moretech.wallets.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.evanli.moretech.wallets.domain.Transaction;
import ru.evanli.moretech.wallets.domain.Wallet;
import ru.evanli.moretech.wallets.domain.dto.MoveDto;
import ru.evanli.moretech.wallets.exception.NotEnoughMoneyException;
import ru.evanli.moretech.wallets.repository.TransactionRepository;
import ru.evanli.moretech.wallets.repository.WalletRepository;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final WalletRepository walletRepository;
    private final TransactionRepository transactionRepository;

    @Transactional
    public void move(MoveDto move) {
        /*Wallet from = walletRepository.getReferenceById(move.getFromWalletId());

        if (from.getAmount() < move.getAmount()) {
            throw new NotEnoughMoneyException();
        }

        Wallet to = walletRepository.findByUserIdAndKind(move.getToUserId(), Wallet.WalletType.PRIVATE);

        from.setAmount(from.getAmount() - move.getAmount());
        to.setAmount(to.getAmount() + move.getAmount());

        Transaction transaction = Transaction.builder()
            .fromWalletId(from.getId())
            .fromUserId(from.getUserId())
            .toWalletId(to.getId())
            .toUserId(to.getUserId())
            .amount(move.getAmount())
            .comment(move.getComment())
            .build();

        walletRepository.save(from);
        walletRepository.save(to);

        transactionRepository.save(transaction);*/
    }
}