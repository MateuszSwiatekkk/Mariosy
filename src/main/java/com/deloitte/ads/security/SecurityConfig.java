package com.deloitte.ads.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    private JwtConverter jwtConverter;

    public SecurityConfig(JwtConverter jwtConverter) {
        this.jwtConverter = jwtConverter;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception  {
        http.csrf().disable()
                .authorizeHttpRequests()
                .antMatchers("/api/users")
                .permitAll()
                .anyRequest()
                .authenticated();

        http.oauth2ResourceServer().jwt().jwtAuthenticationConverter(jwtConverter);
        return http.build();
    }
}
