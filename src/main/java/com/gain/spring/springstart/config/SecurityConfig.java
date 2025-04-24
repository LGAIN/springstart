package com.gain.spring.springstart.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // CSRF 보호 끄기
                .headers(headers -> headers.frameOptions(frameOptions -> frameOptions.sameOrigin())) // H2 iframe 허용
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/**", "/signup", "/h2-console",  "/", "/css/**", "/greet").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/greet")
                        .permitAll()
                )
                .logout((logout) -> logout
                        .logoutSuccessUrl("/gain-spring/greet")
                        .permitAll()
                );

        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}