package ru.evanli.moretech.transactions.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.evanli.moretech.transactions.domain.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
