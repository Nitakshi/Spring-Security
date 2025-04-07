package com.app.security.Controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsController {
    @GetMapping("/greet")
    public String printGreetings(){
        return "Hello Ishan";
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/user")
    public String printUser(){
        return "Hello user";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    public String printAdmin(){
        return "Hello Admin";
    }
}
