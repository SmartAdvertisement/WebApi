package com.sas.webapi.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sas.webapi.Model.Density;
import com.sas.webapi.Services.DensityServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Pınar Köroğlu on 10.03.2018.
 */
@RestController
@RequestMapping("/density")
public class DensityController {

    @Autowired
    private DensityServices densityServices;

    SimpleDateFormat formatter = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z");

    @RequestMapping
    public List<Density> getAll() {
        return this.densityServices.getAll();
    }

    @GetMapping(value = "/{created_at}", produces = "application/json")
    @ResponseBody
    public ResponseEntity<?> getDensityByDate(@PathVariable String created_at) {
        Date created = null;
        Density density = null;
        try {
            created = formatter.parse(created_at);
            density = this.densityServices.getDensity(created);
            if (density == null) {
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }
        } catch (java.text.ParseException e) {

            e.printStackTrace();
        }

        return ResponseEntity.ok(density);

    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity addDensity(@RequestBody String jsonDensity) {
        try {
            Density density = new ObjectMapper().readValue(jsonDensity, Density.class);
            this.densityServices.save(density);

        } catch (Exception e) {

            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseEntity.ok(HttpStatus.OK);
    }


}
