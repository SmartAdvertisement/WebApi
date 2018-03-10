package com.sas.webapi.Controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/")
@RestController
public class MainController {

    @GetMapping("/all")
    public String hello(){
        return "Hello Everyone!";
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/secured")
    public String securedHello(){
        return "Hello Admin!";
    }

}
