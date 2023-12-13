package com.Team4.SmartTowns.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private DataSource dataSource;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    UserDetailsService userDetailsService() {
        JdbcDaoImpl jdbcUserDetails = new JdbcDaoImpl();
        jdbcUserDetails.setDataSource(dataSource);
        jdbcUserDetails.setUsersByUsernameQuery("select username, password, enabled from user_table where username=?");
        jdbcUserDetails.setAuthoritiesByUsernameQuery("select username, authority from user_authorities where username=?");
        return jdbcUserDetails;
    }

    public static final String[] ENDPOINTS_WHITELIST = {
            // all users can see all pages currently, for testing purposes
//            "/**",
            //
            "/",
            "/stylesheets/**",
            "/scripts/**",
            "/trails",
            "/trails/**",
            "/leaderboard",
            "/registration",
            "/registration/newregister",
            "/403",
            "/login",
            "/login/**",
            "/test",
            "/api/**"
    };

    public static final String[] USER_WHITELIST = {
            "/profile",
            "/scan",
            "/logout",
    };

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(request -> request
                        .requestMatchers(ENDPOINTS_WHITELIST).permitAll()
                        .requestMatchers(USER_WHITELIST).hasRole("USER")
                        .anyRequest().hasRole("ADMIN"))
//                .csrf(csrf -> csrf.disable())
                .formLogin(form -> form
                        .loginPage("/login")
                        .permitAll()
                        .defaultSuccessUrl("/login/success")
                        .failureUrl("/login/error"))
                .logout((l) -> l
                        .permitAll()
                        .logoutSuccessUrl("/"))
                .exceptionHandling()
                .accessDeniedPage("/403");

        return http.build();
    }

}

