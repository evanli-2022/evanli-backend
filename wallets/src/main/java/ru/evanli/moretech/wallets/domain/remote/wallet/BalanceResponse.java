package ru.evanli.moretech.wallets.domain.remote.wallet;

import lombok.Data;

@Data
public class BalanceResponse {
    private Double maticAmount;
    private Double coinsAmount;
}
