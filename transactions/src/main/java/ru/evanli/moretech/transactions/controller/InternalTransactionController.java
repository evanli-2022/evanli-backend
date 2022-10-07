package ru.evanli.moretech.transactions.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.evanli.moretech.transactions.domain.dto.MoveDto;
import ru.evanli.moretech.transactions.service.TransactionService;
import ru.evanli.moretech.transactions.service.WalletService;

@RestController
@RequestMapping("/internal/api/transactions")
@RequiredArgsConstructor
public class InternalTransactionController {

    private final TransactionService transactionService;

    @PostMapping
    public void move(MoveDto move) {
        transactionService.move(move);
    }
}
