package com.sas.webapi.Controller;

import com.sas.webapi.Model.AdvertisementCategory;
import com.sas.webapi.Services.AdvertisementServices;
import com.sas.webapi.Services.AgServices;
import com.sas.webapi.Services.CategoryServices;
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

    @Autowired
    private AdvertisementServices advertisementServices;

    @Autowired
    private CategoryServices categoryServices;

    @GetMapping("/agprg")
    public String agprg(Model model){
        try{
            model.addAttribute("lessons",agServices.getAll());
            System.out.print(agServices.getAll());
        }catch(Exception e)
        {
            System.out.print(e);
        }

        return "ag";
    }

    @GetMapping("/reklam-listesi")
    public String advertisementList(Model model){
        try{
            model.addAttribute("advertisement",advertisementServices.getAll());
        }catch(Exception e)
        {
            System.out.print(e);
        }

        return "reklam-listele";
    }

    @GetMapping("/reklam-ekle")
    public String addAdvertisement(Model model){
        try{
            model.addAttribute("category",categoryServices.getAll());
        }catch(Exception e)
        {
            System.out.print(e);
        }

        return "reklam-ekle";
    }

    @GetMapping("/kategoriler")
    public String categories(Model model){
        try{
            model.addAttribute("category",categoryServices.getAll());
        }catch(Exception e)
        {
            System.out.print(e);
        }

        return "category";
    }

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
