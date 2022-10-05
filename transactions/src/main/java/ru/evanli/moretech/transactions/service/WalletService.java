package ru.evanli.moretech.transactions.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.evanli.moretech.transactions.domain.Wallet;
import ru.evanli.moretech.transactions.domain.dto.MoveDto;
import ru.evanli.moretech.transactions.exception.NotEnoughMoneyException;
import ru.evanli.moretech.transactions.exception.WalletNotFoundException;
import ru.evanli.moretech.transactions.repository.WalletRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WalletService {

    private final WalletRepository walletRepository;

    @Transactional(readOnly = true)
    public List<Wallet> getByUserId(Long userId) {
        return walletRepository.findByUserId(userId);
    }

    @Transactional
    public void move(MoveDto move) {
        Wallet from = walletRepository.getReferenceById(move.getFromWalletId());

        if (from.getAmount() < move.getAmount()) {
            throw new NotEnoughMoneyException();
        }

        Wallet to = walletRepository.findByUserIdAndKind(move.getToUserId(), Wallet.WalletType.PRIVATE);

        from.setAmount(from.getAmount() - move.getAmount());
        to.setAmount(to.getAmount() + move.getAmount());

        walletRepository.save(from);
        walletRepository.save(to);
    }
}
