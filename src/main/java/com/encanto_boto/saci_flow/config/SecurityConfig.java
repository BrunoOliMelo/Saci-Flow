package com.encanto_boto.saci_flow.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/tasks/**", "/users/**", "/login/**").permitAll() // Permitir acesso anônimo aos endpoints de tarefas e usuários

                                .anyRequest().authenticated()
                )
                .csrf().disable(); // Desativar CSRF para facilitar os testes com Postman

        return http.build();
    }
}