package ru.evanli.moretech.wallets.domain.remote.wallet;

import lombok.Builder;
import lombok.Data;

@Data
//@Builder
public class TransferResponse {
    private String transaction;
}
