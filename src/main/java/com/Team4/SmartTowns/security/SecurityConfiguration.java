//package com.Team4.SmartTowns.security;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
////import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
////import org.springframework.security.core.userdetails.UserDetailsService;
////import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//import javax.sql.DataSource;
//
//import static org.springframework.security.config.Customizer.withDefaults;
//
//
//// Security Config for DevOps testing
//@Configuration
//@EnableWebSecurity
//public class SecurityConfiguration {
//
//    @Autowired
//    private DataSource dataSource;
//
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
////    @Bean
////    UserDetailsService userDetailsService() {
////        JdbcDaoImpl jdbcUserDetails = new JdbcDaoImpl();
////        jdbcUserDetails.setDataSource(dataSource);
////        jdbcUserDetails.setUsersByUsernameQuery("select username, password, enabled from user_table where username=?");
////        jdbcUserDetails.setAuthoritiesByUsernameQuery("select username, authority from user_authorities where username=?");
////        return jdbcUserDetails;
////    }
//
////    public static final String[] ENDPOINTS_WHITELIST = {
////            // all users can see all pages currently, for testing purposes
//////            "/**",
////            //
////            "/",
////            "/stylesheets/**",
////            "/scripts/**",
////            "/trails",
////            "/trails/**",
////            "/leaderboard",
////            "/registration",
////            "/registration/newregister",
//////            "/403",
////            "/login",
////            "/login/**",
////            "/test",
////            "/api/**"
////    };
////
////    public static final String[] USER_WHITELIST = {
////            "/profile",
////            "/scan",
////            "/logout",
////    };
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests((authz) -> authz
//                        .anyRequest().authenticated()
//
//                )
//                .httpBasic(withDefaults());
//        http.csrf().disable();
//        return http.build();
//    }
//
//    @Bean
//    public InMemoryUserDetailsManager userDetailsService() {
//        UserDetails user = User.withDefaultPasswordEncoder()
//                .username("user")
//                .password("password")
//                .roles("USER")
//                .build();
//        return new InMemoryUserDetailsManager(user);
//    }
//
////    @Bean
////    public WebSecurityCustomizer webSecurityCustomizer() {
////        return (web) -> web.ignoring().antMatchers("/medals", "/");
////    }
//
//
//
//}
//
////        @Override
////        protected void configure(HttpSecurity http) throws Exception {
////            http.authorizeRequests().antMatchers("/**").hasRole("USER").and().httpBasic();
//
////        http.authorizeHttpRequests(request -> request
////                        .antMatchers(ENDPOINTS_WHITELIST).permitAll()
////                        .antMatchers(USER_WHITELIST).hasRole("USER")
////                        .anyRequest().hasRole("ADMIN"))
//////                .csrf(csrf -> csrf.disable())
////                .formLogin(form -> form
////                        .loginPage("/login")
////                        .permitAll()
////                        .defaultSuccessUrl("/login/success")
////                        .failureUrl("/login/error"))
////                .logout((l) -> l
////                        .permitAll()
////                        .logoutSuccessUrl("/"))
////                .exceptionHandling()
////                .accessDeniedPage("/403");
//
////        return http.build();
////    }
////
////
////}
package com.Team4.SmartTowns.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;

import javax.sql.DataSource;

import static org.springframework.web.servlet.function.RequestPredicates.headers;


// Security Config for DevOps testing
@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

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
            "/medals",
            "/leaderboard",
            "/registration",
            "/registration/newregister",
//            "/403",
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
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .headers((headers) -> headers.disable());
//        http
//                .csrf(AbstractHttpConfigurer::disable);

        http.authorizeHttpRequests((authz) -> authz
                                .requestMatchers(ENDPOINTS_WHITELIST).permitAll()
                                .requestMatchers(USER_WHITELIST).hasRole("USER")
                        .requestMatchers("/").permitAll()
                        .requestMatchers("/console/**").permitAll()
                        .anyRequest().hasRole("ADMIN")
                )
//                .csrf(csrf -> csrf.disable())
                .formLogin(form -> form
                        .loginPage("/login")
                        .permitAll()
                        .defaultSuccessUrl("/login/success")

                        .failureUrl("/login/error")
                )

                .logout((l) -> l
                        .permitAll()
                        .logoutSuccessUrl("/"));
//                .exceptionHandling()
//                .accessDeniedPage("/403");

        return http.build();
    }


}