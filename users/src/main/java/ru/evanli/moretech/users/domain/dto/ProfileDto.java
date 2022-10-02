package ru.evanli.moretech.users.domain.dto;

import lombok.Builder;
import lombok.Data;
import ru.evanli.moretech.users.domain.UserRole;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class ProfileDto {
    private Long id;
    private String username;
    private String fullName;
    private String position;
    private List<String> roles;
    private LocalDate createdAt;
}
