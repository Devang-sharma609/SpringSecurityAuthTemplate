package com.devang.iam.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class MySecConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        return http
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/signup").permitAll()
                .anyRequest().authenticated()
                )
                .csrf(csrf->csrf.disable())
                .formLogin(withDefaults())
                .httpBasic(withDefaults())
                .build();
    }
}