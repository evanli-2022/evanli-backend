package ru.evanli.moretech.users.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.evanli.moretech.users.domain.User;
import ru.evanli.moretech.users.domain.dto.UserDto;
import ru.evanli.moretech.users.repository.UserRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<UserDto> getAll() {
        return userRepository.findAll().stream()
            .map(u -> UserDto.builder()
                .id(u.getId())
                .fullName(u.getFullname())
                .position(u.getPosition())
                .build()
            )
            .collect(Collectors.toList());
    }

    @Transactional
    public UserDto getById(Long id) {
        return userRepository.findById(id)
            .map(u -> UserDto.builder()
                .id(u.getId())
                .fullName(u.getFullname())
                .position(u.getPosition())
                .build()
            ).orElseThrow(EntityNotFoundException::new);
    }

    @Transactional(readOnly = true)
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Transactional
    public void save(User user) {
        userRepository.save(user);
    }
}
