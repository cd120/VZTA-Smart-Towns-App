//package com.Team4.SmartTowns.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//import static org.springframework.security.config.Customizer.withDefaults;
//
//@Configuration
//@EnableWebSecurity
//public class CsrfSecurityConfig {
//
//    @Bean
//    public SecurityFilterChain FilterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf((csrf) -> csrf.disable())
//                .headers((headers) ->
//                        headers
//                                .contentTypeOptions(withDefaults())
//                                .xssProtection(withDefaults())
//                                .cacheControl(withDefaults())
//                                .httpStrictTransportSecurity(withDefaults())
//                                .frameOptions(withDefaults())
//                                );
//        return http.build();
//    }
//}
