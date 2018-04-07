package com.sas.webapi.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sas.webapi.Model.Density;
import com.sas.webapi.Services.DensityServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Pınar Köroğlu on 10.03.2018.
 */
@RestController
@RequestMapping("/density")
public class DensityController {

    @Autowired
    private DensityServices densityServices;

    @RequestMapping
    public List<Density> getAll() {
        return this.densityServices.getAll();
    }

    @ResponseBody
    @RequestMapping(method= RequestMethod.POST)
    public ResponseEntity addDensity(@RequestBody String jsonDensity){
        try{
            Density density = new ObjectMapper().readValue(jsonDensity,Density.class);
            this.densityServices.save(density);

        }catch (Exception e){

            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseEntity.ok(HttpStatus.OK);
    }




}
