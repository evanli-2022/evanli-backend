package ru.evanli.moretech.tasks.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class GetMoneyService {

    private final RestTemplate restTemplate = new RestTemplate();

    private final RemoteAuthService authService;

    public void accrueMoney(Double amount) {
        Long userId = authService.getUserDetails().getId();

        //TODO send rest request to wallets service
    }
}
