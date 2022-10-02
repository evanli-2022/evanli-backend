package ru.evanli.moretech.users.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@RequiredArgsConstructor
public enum Role implements GrantedAuthority {

    ADMIN("ADMIN"),
    HR("HR"),
    EMPLOYEE("EMPLOYEE");

    private final String value;

    @Override
    public String getAuthority() {
        return value;
    }

}
