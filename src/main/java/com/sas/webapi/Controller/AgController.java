package com.sas.webapi.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sas.webapi.Model.Advertisement;
import com.sas.webapi.Model.AdvertisementCategory;
import com.sas.webapi.Model.AgProgramlama;
import com.sas.webapi.Services.AdvertisementServices;
import com.sas.webapi.Services.AgServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Pınar Köroğlu on 4.04.2018.
 */
@RestController
@RequestMapping("/agProgramlama")
public class AgController {

    @Autowired
    private AgServices agServices;


    @ResponseBody
    @RequestMapping(method= RequestMethod.POST)
    public ResponseEntity addAgProgramlama(@RequestBody String jsonAgRepository){
        try{
            AgProgramlama agProgramlama = new ObjectMapper().readValue(jsonAgRepository,AgProgramlama.class);
            this.agServices.save(agProgramlama);

        }catch (Exception e){

            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
