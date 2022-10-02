package ru.evanli.moretech.users.domain;

import lombok.Data;
import ru.evanli.moretech.users.converter.UserRoleListConverter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "user", schema = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "roles")
    @Convert(converter = UserRoleListConverter.class)
    private List<UserRole> roles;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "positionn")
    private String position;

    @Column(name = "created_at")
    private LocalDate createdAt;
}
