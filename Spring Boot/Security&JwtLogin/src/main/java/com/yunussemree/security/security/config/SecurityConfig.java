package com.yunussemree.security.security.config;

import com.yunussemree.security.security.jwt.AuthTokenFilter;
import com.yunussemree.security.security.jwt.JwtAuthEntryPoint;
import com.yunussemree.security.security.user.CustomerDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@RequiredArgsConstructor
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
@Configuration
public class SecurityConfig {


    private final CustomerDetailsService customerDetailsService;
    private final JwtAuthEntryPoint jwtAuthEntryPoint;


    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {

        UserDetails admin = User.builder()

                .username("admin")
                .password("{noop}test12345*")
                .roles("ADMIN")
                .build();

        UserDetails user = User.builder()
                .username("user")
                .password("{noop}test12345") // {noop} is a prefix that tells no need to encode the password
                .roles("USER")
                .build();
        /*
        {bcrypt} -> BCryptPasswordEncoder,
        {pbkdf2} -> Pbkdf2PasswordEncoder,
        {scrypt} -> SCryptPasswordEncoder,
        {sha256} -> StandardPasswordEncoder.
         */


        return new InMemoryUserDetailsManager(admin, user);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.authorizeHttpRequests(configurer ->

                configurer
                        .requestMatchers(HttpMethod.POST, "/customers/create").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/customers/customerAll").hasRole("USER")
                        .requestMatchers(HttpMethod.PUT, "/customers/updateCustomer").hasRole("USER")
                        .requestMatchers(HttpMethod.GET, "/customers/deleteCustomer/**").hasRole("ADMIN")
        );

        // use HTTP Basic Authentication
        httpSecurity.httpBasic(Customizer.withDefaults());

        // disable Cross Site Request Forgery (CSFR)
        // in general not required for stateles rest apıs that use post,
        // put delete and/or patch

        httpSecurity.csrf(csfr -> csfr.disable());


        return httpSecurity.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {return new BCryptPasswordEncoder();}

    @Bean
    public AuthTokenFilter authTokenFilter() {return new AuthTokenFilter();}

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        var authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(customerDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }
}