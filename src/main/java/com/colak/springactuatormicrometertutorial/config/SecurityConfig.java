package com.colak.springactuatormicrometertutorial.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    // When spring security is enabled only health endpoint is accessible by default
    // The configuration below does not work
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                        customizer -> customizer.requestMatchers("/actuator/env")
                                .authenticated()
                                .anyRequest()
                                .permitAll())
                .httpBasic(Customizer.withDefaults());
        return http.build();

    }
}
