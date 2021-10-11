 package com.example.hotel.model.security;

import com.example.hotel.model.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


import javax.sql.DataSource;

@Configuration
@EnableGlobalMethodSecurity (
        securedEnabled = true,
        jsr250Enabled = true,
        prePostEnabled = true )



public class ApplicationConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AdminDetailsServiceImpl adminDetailsServiceImp;

    @Override
    protected void configure (AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(adminDetailsServiceImp).passwordEncoder(passwordEncoder());

    }

    @Configuration
    @Order(1)
    public static class ApiWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {
        protected void configure(HttpSecurity http) throws Exception {
            http.cors().and()
                    .antMatcher("/api/**") // sécurité sur tout ce qui est api/**
                    .csrf()
                    .disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // On utilise pas les sessions, toute req est déconnectée suite à l'exécution
                    .and().authorizeRequests(authorize -> authorize
                            .anyRequest().authenticated() //hasRole("ADMIN")
                    )
                    .httpBasic();
        }
    }

   @Bean
   public PasswordEncoder passwordEncoder() {
       return new BCryptPasswordEncoder();
   }

}


