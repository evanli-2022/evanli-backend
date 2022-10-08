package ru.evanli.moretech.wallets.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.evanli.moretech.wallets.domain.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    Transaction getTopByHash(String hash);
}
