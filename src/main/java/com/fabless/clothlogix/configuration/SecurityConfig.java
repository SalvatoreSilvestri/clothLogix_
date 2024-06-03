package com.fabless.clothlogix.configuration;

import com.fabless.clothlogix.Entity.UtenteEntity;
import com.fabless.clothlogix.service.Impl.UtenteService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final UtenteService utenteService;

    public SecurityConfig(UtenteService utenteService) {
        this.utenteService = utenteService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .requestMatchers("/user/**").hasRole("USER")
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/authentication/login") // Path corretto per la pagina di login
                        .loginProcessingUrl("/authentication/login/process") // Path corretto per l'elaborazione del login
                        .failureUrl("/authentication/login?failed") // Path corretto per il fallimento del login
                        .usernameParameter("username")
                        .passwordParameter("password")
                        .permitAll()
                )
                .logout(logout -> logout
                        .permitAll()
                );
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> {
            if ("utente".equals(username)) {
                return User.withUsername("utente")
                        .password(passwordEncoder().encode("utente"))
                        .roles("USER")
                        .build();
            }
            try {
                UtenteEntity utente = utenteService.findByUsername(username);
                if (utente == null) {
                    throw new UsernameNotFoundException("User not found with username: " + username);
                }
                return new User(utente.getLogin().getUsername(), utente.getLogin().getPassword(), Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")));
            } catch (Exception e) {
                throw new UsernameNotFoundException("User not found with username: " + username, e);
            }
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}