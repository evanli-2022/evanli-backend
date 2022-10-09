package ru.evanli.moretech.tasks.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.evanli.moretech.tasks.domain.UserDetailsImpl;
import ru.evanli.moretech.tasks.domain.dto.ProfileDto;

@Service
@RequiredArgsConstructor
public class RemoteAuthService {

    private final RestTemplate authRestTemplate = new RestTemplate();

    @Value("${auth.server}")
    private final String authServer;

    public ProfileDto auth(String jwt) {

        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.AUTHORIZATION, "Bearer " + jwt);
        HttpEntity<Void> request = new HttpEntity<>(null, headers);

        ResponseEntity<ProfileDto> response = authRestTemplate.exchange(authServer, HttpMethod.GET, request, ProfileDto.class);

        if (response.getStatusCode().equals(HttpStatus.OK)) {
            return response.getBody();
        }
        throw new RuntimeException();
    }

    public UserDetailsImpl getUserDetails() {
        return (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
