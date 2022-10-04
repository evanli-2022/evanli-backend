package ru.evanli.moretech.users.domain;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(schema = "users", name = "user")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Type(type = "jsonb")
    @Column(name = "roles", columnDefinition = "jsonb")
    private List<UserRole> roles;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "positionn")
    private String position;

    @Column(name = "created_at")
    private LocalDate createdAt;
}
