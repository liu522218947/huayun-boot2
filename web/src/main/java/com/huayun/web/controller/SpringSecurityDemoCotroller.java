package com.huayun.web.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringSecurityDemoCotroller {
    private String has;

    @RequestMapping("/")
    public String home(){
        return "hello spring boot 2";
    }

    @RequestMapping("/first")
    public String first(){
        return "hello spring security";
    }
    @RequestMapping("/manager")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String adminManager(){
        return "admin role";
    }
    @RequestMapping(value="/user/{id}",method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_USERS') and #id>3")
    public String userManager(@PathVariable("id") Integer id){
        return "user role";
    }
}
