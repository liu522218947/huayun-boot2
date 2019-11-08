package com.huayun.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ComponentScan(basePackages = {"com.huayun.service","com.huayun.web","com.huayun.dao","com.huayun.model"})
@EnableAutoConfiguration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableTransactionManagement
@MapperScan("com.huayun.dao")
public class WebApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);
	}

}
