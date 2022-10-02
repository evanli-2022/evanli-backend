package ru.evanli.moretech.users.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import ru.evanli.moretech.users.domain.User;
import ru.evanli.moretech.users.domain.UserDetailsImpl;
import ru.evanli.moretech.users.domain.UserRole;
import ru.evanli.moretech.users.domain.dto.jwt.JwtResponse;
import ru.evanli.moretech.users.domain.dto.jwt.LoginRequest;
import ru.evanli.moretech.users.domain.dto.jwt.MessageResponse;
import ru.evanli.moretech.users.domain.dto.jwt.SignupRequest;
import ru.evanli.moretech.users.service.UserService;
import ru.evanli.moretech.users.utils.JwtUtils;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    
    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final PasswordEncoder encoder;
    private final JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateEmployee(@RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities()
            .stream().map(item -> item.getAuthority())
            .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
            userDetails.getId(),
            userDetails.getUsername(),
            userDetails.getPosition(), roles));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignupRequest signUpRequest) {

        if (userService.existsByUsername(signUpRequest.getUsername())) {

            return ResponseEntity.badRequest()
                .body(new MessageResponse("Error: Username is already taken!"));
        }

        // Create new employee account
        User employee = new User();
        employee.setUsername(signUpRequest.getUsername());
        employee.setPosition(signUpRequest.getPosition());
        employee.setPassword(encoder.encode(signUpRequest.getPassword()));
        employee.setRoles(List.of(UserRole.ROLE_EMPLOYEE));
        
        userService.save(employee);

        return ResponseEntity.ok(new MessageResponse("Employee registered successfully!"));
    }
}
