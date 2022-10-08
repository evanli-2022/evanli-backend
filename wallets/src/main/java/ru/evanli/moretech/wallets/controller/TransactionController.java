package ru.evanli.moretech.wallets.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.evanli.moretech.wallets.domain.Transaction;
import ru.evanli.moretech.wallets.domain.dto.TransferData;
import ru.evanli.moretech.wallets.service.TransactionService;
import ru.evanli.moretech.wallets.service.WalletService;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;
    private final WalletService walletService;

    @GetMapping("/{hash}")
    public Transaction get(@PathVariable String hash) {
        return transactionService.getByHash(hash);
    }

    @PostMapping
    public Transaction transfer(TransferData transferData) {
        return walletService.transfer(transferData);
    }

    @PutMapping("/{hash}")
    public Transaction refresh(@PathVariable String hash) {
        return transactionService.refresh(hash);
    }

    @GetMapping
    public List<Transaction> getAll() {
        return transactionService.getAll();
    }

    @PutMapping
    public void refresh() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                transactionService.refresh();
            }
        }).start();
    }
}
