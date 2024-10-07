package com.example.its.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {


    @Bean
    protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
        // h2-consoleの設定
        http
                .authorizeRequests().antMatchers("/h2-console/**").permitAll()
                .and()
                .csrf().ignoringAntMatchers("/h2-console/**")
                .and()
                .headers().frameOptions().disable();

        http
                .authorizeRequests()
                .mvcMatchers("/login").permitAll()       // ログインページは誰でもアクセス可能にする
                .mvcMatchers("/users/**").hasAuthority("ADMIN")   //  /users/～以降のURLはADMIN権限が必要
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login");

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new Pbkdf2PasswordEncoder();
    }
}
