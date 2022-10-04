package ru.evanli.moretech.transactions.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@RequiredArgsConstructor
public class WebSecurityConfig {

//    TODO Create filter and uncomment this
//    private final AuthTokenFilter authenticationJwtTokenFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http)
        throws Exception {

        http
            .cors()
            .and()
            .csrf().disable().exceptionHandling()
//            .authenticationEntryPoint(unauthorizedHandler)
            .and()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .authorizeRequests()
            .antMatchers("/api/wallets/**").permitAll()
            .antMatchers("/internal/**").permitAll()
            .antMatchers("/swagger-ui/**", "/transactions/api-docs/**").permitAll()
            .anyRequest()
            .authenticated();

//        http.addFilterBefore(authenticationJwtTokenFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    /*@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }*/

    /*@Bean
    public AuthTokenFilter authenticationJwtTokenFilter(AuthService authService) {
        return new AuthTokenFilter(authService, userDetailsService);
    }*/

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}
