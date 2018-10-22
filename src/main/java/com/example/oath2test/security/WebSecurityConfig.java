package com.example.oath2test.security;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       auth.inMemoryAuthentication()
               .withUser("admin").password("$2a$10$WtC22YLCg2qkIuEjHy1VP.kZjgudU8xqJlv/ueqp..birwenlQ.U6").roles("ADMIN")
               .and()
               .passwordEncoder(new BCryptPasswordEncoder());

        auth.inMemoryAuthentication()
                .withUser("manager").password("$2a$10$WtC22YLCg2qkIuEjHy1VP.kZjgudU8xqJlv/ueqp..birwenlQ.U6").roles("MANAGER")
                .and()
                .passwordEncoder(new BCryptPasswordEncoder());

        auth.inMemoryAuthentication()
                .withUser("noob").password("$2a$10$WtC22YLCg2qkIuEjHy1VP.kZjgudU8xqJlv/ueqp..birwenlQ.U6").roles("NOOB")
                .and()
                .passwordEncoder(new BCryptPasswordEncoder());

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/admin").hasAnyRole("ADMIN")
                .antMatchers("/manager").hasAnyRole("MANAGER")
                .antMatchers("/noob").hasAnyRole("NOOB","MANAGER","ADMIN")
                .and()
                .formLogin()
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
    }


}
