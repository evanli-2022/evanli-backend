package ru.evanli.moretech.wallets.domain.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
//@Builder
public class ProfileDto {
    private Long id;
    private String username;
    private String fullName;
    private String position;
    private List<String> roles;
    private LocalDate createdAt;
}
