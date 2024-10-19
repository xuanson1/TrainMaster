package com.example.springmvc.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class UserConfiguration {

    @Bean
    @Autowired
    public JdbcUserDetailsManager jdbcUserDetailsManager(DataSource dataSource){
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
        jdbcUserDetailsManager.setUsersByUsernameQuery("SELECT username, password FROM account WHERE username=?");
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("SELECT a.username, r.role_name FROM account a JOIN role r ON a.role_id = r.role_id WHERE a.username=?");
        return jdbcUserDetailsManager;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(
                configurer->configurer
                        .requestMatchers(HttpMethod.GET, "/client/getAllClient").hasAnyRole("PT","FM")
//                        .requestMatchers(HttpMethod.GET, "/api/students/**").hasAnyRole("TEACHER", "MANAGER", "ADMIN")
//                        .requestMatchers(HttpMethod.POST, "/api/students").hasAnyRole("MANAGER", "ADMIN")
//                        .requestMatchers(HttpMethod.PUT, "/api/students").hasAnyRole("MANAGER", "ADMIN")
//                        .requestMatchers(HttpMethod.DELETE, "/api/students/**").hasRole("ADMIN")
        );

        http.httpBasic(Customizer.withDefaults());

        http.csrf(AbstractHttpConfigurer::disable);
        // csrf - cross site request forgery

        return http.build();
    }
}
