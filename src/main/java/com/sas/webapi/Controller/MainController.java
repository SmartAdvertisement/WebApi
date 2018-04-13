package com.sas.webapi.Controller;

import com.sas.webapi.Services.AgServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/")
@Controller
public class MainController {

    @Autowired
    private AgServices agServices;


    @GetMapping("/agprg")
    public String index(Model model){
        try{
            model.addAttribute("lessons",agServices.getAll());
            System.out.print(agServices.getAll());
        }catch(Exception e)
        {
            System.out.print(e);
        }

        return "ag";
    }

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String index(){return "index1";}

    @RequestMapping(value = "/form",method = RequestMethod.GET)
    public String form(){return "form";}

    @GetMapping("/login")
    public String login(){return "login";}

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
