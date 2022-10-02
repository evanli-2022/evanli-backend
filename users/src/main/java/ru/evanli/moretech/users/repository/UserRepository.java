package ru.evanli.moretech.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.evanli.moretech.users.domain.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> getByUsername(String username);
}
