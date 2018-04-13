package com.sas.webapi.Controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/")
@Controller
public class MainController {

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String index(){return "index1";}

    @GetMapping("/login")
    public String login(){return "login";}

    @GetMapping("/reklam")
    public String form(){return "form";}

    @GetMapping("/kategori")
    public String index2(){return "category";}

    @GetMapping("/all")
    public String hello(){
        return "Hello Everyone!";
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/secured/all")
    public String securedHello(){
        return "Hello Admin!";
    }

}
