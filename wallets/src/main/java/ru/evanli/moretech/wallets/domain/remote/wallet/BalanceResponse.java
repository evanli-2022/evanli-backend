package ru.evanli.moretech.wallets.domain.remote.wallet;

import lombok.Data;

@Data
public class BalanceResponse {
    private Integer maticAmount;
    private Integer coinsAmount;
}
