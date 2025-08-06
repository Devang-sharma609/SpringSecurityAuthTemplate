package com.devang.iam.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class MySecConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        CsrfTokenRequestAttributeHandler reqHandler = new CsrfTokenRequestAttributeHandler();
        reqHandler.setCsrfRequestAttributeName("_csrf");

        return http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/signup").permitAll()
                        .requestMatchers("/").authenticated()
                        .anyRequest().authenticated())
                .csrf(csrf -> csrf
                                    .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                                    .csrfTokenRequestHandler(reqHandler))
                .formLogin(withDefaults())
                .httpBasic(withDefaults())
                .build();
    }
}