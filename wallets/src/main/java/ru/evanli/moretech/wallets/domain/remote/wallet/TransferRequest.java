package ru.evanli.moretech.wallets.domain.remote.wallet;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TransferRequest {
    private String fromPrivateKey;
    private String toPrivateKey;
    private Double amount;
}
