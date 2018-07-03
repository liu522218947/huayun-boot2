package com.huayun.web.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@Slf4j
public class SpringSecurigyConfig extends WebSecurityConfigurerAdapter{
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/js/**","/css/**","/images/**");
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/","/index").permitAll()
                .anyRequest().authenticated()
                .and().logout().permitAll()
                .and().formLogin();
        http.csrf().disable();
    }
    @Autowired
    public void configGlobal(AuthenticationManagerBuilder auto) throws Exception {
        log.debug("开始身份验证......");
        auto.inMemoryAuthentication().
                passwordEncoder(new BCryptPasswordEncoder()).
                withUser("admin").
                password(new BCryptPasswordEncoder().encode("123456")).
                roles("ADMIN");
        auto.inMemoryAuthentication().
                passwordEncoder(new BCryptPasswordEncoder()).
                withUser("zhangsan").
                password(new BCryptPasswordEncoder().encode("zhangsan")).
                roles("USERS");
    }
}
