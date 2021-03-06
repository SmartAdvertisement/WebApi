package com.sas.webapi.Controller;

import com.sas.webapi.Services.AdvertisementServices;
import com.sas.webapi.Services.AgServices;

import com.sas.webapi.Services.CategoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;

@RequestMapping("/")
@Controller
public class MainController {

    @Autowired
    private AgServices agServices;

    @Autowired
    private AdvertisementServices advertisementServices;

    @Autowired
    private CategoryServices categoryServices;

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/reklamListesi")
    public String advertisementList(Model model){
        try{
            model.addAttribute("advertisement",advertisementServices.getAllIfActivestatusTrue());
        }catch(Exception e)
        {
            System.out.print(e);
        }

        return "reklam-listele";
    }
    @PreAuthorize("hasAnyRole('ADMIN')")
    @RequestMapping(value = "/category",method = RequestMethod.GET)
    public String index(Model model){
        try{
            model.addAttribute("categoryList",categoryServices.getAll());
        }catch(Exception e)
        {
            System.out.print(e);
        }

        return "category";
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @RequestMapping(value = "/reklamEkle",method = RequestMethod.GET)
    public String reklamEkle(Model model){
        try{
            model.addAttribute("category",categoryServices.getAll());
        }catch(Exception e)
        {
            System.out.print(e);
        }

        return "reklam-ekle";
    }

    @GetMapping("/login")
    public String login(){return "login";}


    @GetMapping("/chat")
    public String chat(){return "chat";}

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }
    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/form")
    public String form(){return "form";}

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/")
    public String index1(){
        return "welcome";
    }

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
