package ru.evanli.moretech.wallets.domain.remote.wallet;

import lombok.Data;

@Data
public class WalletKeysResponse {
    private String publicKey;
    private String privateKey;
}
