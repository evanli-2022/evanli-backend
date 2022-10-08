package ru.evanli.moretech.wallets.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.evanli.moretech.wallets.domain.dto.TransferData;
import ru.evanli.moretech.wallets.domain.dto.WalletDto;
import ru.evanli.moretech.wallets.service.WalletService;

import java.util.List;

import static ru.evanli.moretech.wallets.config.OpenApiConfig.BEARER_TOKEN_SECURITY_SCHEME;

@RestController
@RequestMapping("/api/wallets")
@SecurityRequirement(name = BEARER_TOKEN_SECURITY_SCHEME)
@RequiredArgsConstructor
public class WalletController {

    private final WalletService walletService;

    @GetMapping("/{userId}")
    public WalletDto getWallets(@PathVariable Long userId) {
        return walletService.getWalletDtoByUserId(userId);
    }
}
