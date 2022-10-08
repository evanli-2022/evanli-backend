package ru.evanli.moretech.wallets.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.evanli.moretech.wallets.domain.dto.TransactionStatusResponse;
import ru.evanli.moretech.wallets.domain.remote.wallet.BalanceResponse;
import ru.evanli.moretech.wallets.domain.remote.wallet.TransferRequest;
import ru.evanli.moretech.wallets.domain.remote.wallet.TransferResponse;
import ru.evanli.moretech.wallets.domain.remote.wallet.WalletKeysResponse;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class RemoteWalletApiService {

    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${wallet.api.prefix}")
    private final String apiPrefix;

    public BalanceResponse getBalance(String publicKey) {
        return restTemplate.getForObject(
            apiPrefix + "/v1/wallets/{publicKey}/balance",
            BalanceResponse.class,
            Map.of(
                "prefix", apiPrefix,
                "publicKey", publicKey
            )
        );
    }

    public WalletKeysResponse createWallet() {
        return restTemplate.postForObject(
            apiPrefix + "/v1/wallets/new",
            null,
            WalletKeysResponse.class
        );
    }

    public TransferResponse transfer(TransferRequest request) {
        return restTemplate.postForObject(
            apiPrefix + "/v1/transfers/ruble",
            request,
            TransferResponse.class
        );
    }

    public TransactionStatusResponse getStatus(String hash) {
        return restTemplate.getForObject(
            apiPrefix + "/v1/transfers/status/{hash}",
            TransactionStatusResponse.class,
            Map.of("hash", hash)
        );
    }

}