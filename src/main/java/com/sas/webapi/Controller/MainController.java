package com.sas.webapi.Controller;

import com.sas.webapi.Services.AdvertisementServices;
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

    @Autowired
    private AdvertisementServices advertisementServices;

    @GetMapping("/agprogramlama")
    public String agprg(Model model){
        try{
            model.addAttribute("ders",agServices.getAll());
            System.out.print(agServices.getAll());
        }catch(Exception e)
        {
            System.out.print(e);
        }

        return "index";
    }
    @GetMapping("/agprogramlama2")
    public String agprg2(Model model){
        try{
            model.addAttribute("lessons",agServices.getAll());
            System.out.print(agServices.getAll());
        }catch(Exception e)
        {
            System.out.print(e);
        }

        return "ag";
    }
    @GetMapping("/reklamListesi")
    public String advertisementList(Model model){
        try{
            model.addAttribute("advertisement",advertisementServices.getAll());
        }catch(Exception e)
        {
            System.out.print(e);
        }

        return "reklam-listele";
    }

    @RequestMapping(value = "/kategori",method = RequestMethod.GET)
    public String index(){return "category";}

    @RequestMapping(value = "/reklam",method = RequestMethod.GET)
    public String reklamEkle(){return "reklam-ekle";}

    @GetMapping("/login")
    public String login(){return "login";}

    @GetMapping("/form")
    public String form(){return "form";}

    @GetMapping("/")
    public String index1(){return "index1";}

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
