package ru.evanli.moretech.transactions.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.evanli.moretech.transactions.domain.Wallet;
import ru.evanli.moretech.transactions.service.WalletService;

import java.util.List;

import static ru.evanli.moretech.transactions.config.OpenApiConfig.BEARER_TOKEN_SECURITY_SCHEME;

@RestController
@RequestMapping("/api/wallets")
@SecurityRequirement(name = BEARER_TOKEN_SECURITY_SCHEME)
@RequiredArgsConstructor
public class WalletController {

    private final WalletService walletService;

    @GetMapping("/{userId}")
    public List<Wallet> getWallets(@PathVariable Long userId) {
        return walletService.getByUserId(userId);
    }
}
