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
/////   below should be placed in SecurityConfiguration.java for security customisation
//    @Bean
//    public DataSource dataSource() {
//        return new EmbeddedDatabaseBuilder()
//                .setType(EmbeddedDatabaseType.H2)
//                .addScript(JdbcDaoImpl.DEFAULT_USER_SCHEMA_DDL_LOCATION)
//                .build();
//    }
////    @Override
//    @Bean
//    public UserDetailsManager users(DataSource dataSource) {
//        UserDetails user = User.withDefaultPasswordEncoder()
//                .username("user")
//                .password("password")
//                .roles("USER")
//                .build();
//        JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
//        users.createUser(user);
//        return users;
//    }

//    @Bean
//    public InMemoryUserDetailsManager userDetailsService() {
//        UserDetails user = User.withDefaultPasswordEncoder()
//                .username("user")
//                .password("password")
//                .roles("USER")
//                .build();
//        return new InMemoryUserDetailsManager(user);
//    }
//}
