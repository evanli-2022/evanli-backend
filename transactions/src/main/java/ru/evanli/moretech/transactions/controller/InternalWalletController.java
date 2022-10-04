package ru.evanli.moretech.transactions.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.evanli.moretech.transactions.domain.dto.MoveDto;
import ru.evanli.moretech.transactions.service.WalletService;

@RestController
@RequestMapping("/internal/api/wallets")
@RequiredArgsConstructor
public class InternalWalletController {

    private final WalletService walletService;

    @PostMapping("/move")
    public void move(MoveDto move) {
        walletService.move(move);
    }
}
