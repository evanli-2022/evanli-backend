package ru.evanli.moretech.users.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.evanli.moretech.users.domain.User;
import ru.evanli.moretech.users.domain.UserDetailsImpl;
import ru.evanli.moretech.users.repository.UserRepository;

@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.getByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException(" User Not Found with username: " + username));

        return UserDetailsImpl.build(user);
    }
}
