package ru.evanli.moretech.wallets.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.evanli.moretech.wallets.domain.Wallet;

import java.util.List;

public interface WalletRepository extends JpaRepository<Wallet, Long> {

    List<Wallet> findByUserId(Long userId);

    Wallet getTopByUserId(Long userId);
}
