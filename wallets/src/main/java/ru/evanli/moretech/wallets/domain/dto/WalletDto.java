package ru.evanli.moretech.wallets.domain.dto;

import lombok.Builder;
import lombok.Getter;
import ru.evanli.moretech.wallets.domain.Wallet;
import ru.evanli.moretech.wallets.domain.remote.wallet.BalanceResponse;

@Getter
@Builder
public class WalletDto {
    private Long id;
    private Long userId;
    private Wallet.WalletType kind;
    private String title;
    private BalanceResponse balance;
}
