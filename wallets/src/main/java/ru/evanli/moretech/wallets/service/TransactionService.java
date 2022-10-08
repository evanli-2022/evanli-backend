package ru.evanli.moretech.wallets.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpServerErrorException;
import ru.evanli.moretech.wallets.domain.Transaction;
import ru.evanli.moretech.wallets.domain.dto.TransactionStatusResponse;
import ru.evanli.moretech.wallets.domain.dto.TransferData;
import ru.evanli.moretech.wallets.repository.TransactionRepository;
import ru.evanli.moretech.wallets.repository.WalletRepository;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final RemoteWalletApiService remoteWalletApiService;

    @Transactional(propagation = Propagation.REQUIRED)
    public Transaction save(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Transactional(readOnly = true)
    public Transaction getByHash(String hash) {
        return transactionRepository.getTopByHash(hash);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Transaction refresh(String hash) {
        Transaction transaction = transactionRepository.getTopByHash(hash);
        return refresh(transaction);
    }

    @Transactional
    public void refresh() {
        log.info("Transaction refresh started");
        List<Transaction> transactions = transactionRepository.findAll();
        for (Transaction transaction : transactions) {
            refresh(transaction);
        }
    }

    @Transactional(readOnly = true)
    public List<Transaction> getAll() {
        return transactionRepository.findAll();
    }

    private Transaction refresh(Transaction transaction) {
        try {
            TransactionStatusResponse statusResponse = remoteWalletApiService.getStatus(transaction.getHash());
            transaction.setStatus(statusResponse.getStatus());
            transaction = transactionRepository.save(transaction);
            log.info("Transaction refreshed: {}", transaction);
        } catch (HttpServerErrorException e) {
            log.warn("Transaction {} status fetch failed: {}", transaction.getHash(), e.getMessage());
        } catch (Exception e) {
            log.warn("Transaction {} status fetch failed", transaction.getHash());
            log.warn("Transaction status fetch failed", e);
        }
        return transaction;
    }
}
