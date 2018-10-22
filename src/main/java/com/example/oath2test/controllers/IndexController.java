package com.example.oath2test.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {


    @GetMapping("admin")
    public String home(){
        return "****ADMIN****** Hello! " + SecurityContextHolder.getContext().getAuthentication().getName();
    }

    @GetMapping("manager")
    public String manager(){
        return "****MANAGER****** Hello! " + SecurityContextHolder.getContext().getAuthentication().getName();
    }

    @GetMapping("noob")
    public String noob(){
        return "****NOOB****** Hello! " + SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
