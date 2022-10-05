package ru.evanli.moretech.transactions.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.evanli.moretech.transactions.domain.Wallet;

import java.util.List;

public interface WalletRepository extends JpaRepository<Wallet, Long> {

    List<Wallet> findByUserId(Long userId);

    Wallet findByUserIdAndKind(Long userId, Wallet.WalletType kind);
}
