package com.sas.webapi.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sas.webapi.Model.AdvertisementCategory;
import com.sas.webapi.Repository.CategoryRepository;
import com.sas.webapi.Services.AdvertisementServices;
import com.sas.webapi.Model.Advertisement;
import com.sas.webapi.Services.CategoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Pınar Köroğlu on 10.03.2018.
 */
@RestController
@RequestMapping("/advertisement")
public class AdvertisementController {
    @Autowired
    private AdvertisementServices advertisementService;
    @Autowired
    private CategoryRepository categoryRepository;
    @RequestMapping
    public List<Advertisement> getAll() {
        return this.advertisementService.getAll();
    }

    @ResponseBody
    @RequestMapping(method= RequestMethod.POST)
    public ResponseEntity addAdvertisement(@RequestBody String jsonAdvertisement){
        try{
            Advertisement advertisement = new ObjectMapper().readValue(jsonAdvertisement,Advertisement.class);
            advertisement.setDurationTime(1);
            AdvertisementCategory category = categoryRepository.findRolesById(1);
            advertisement.setAdvertisementCategory(category);
            this.advertisementService.save(advertisement);

        }catch (Exception e){

            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity deleteById(@PathVariable int id){
        try{
            if(!this.advertisementService.checkAdvertisementExistenceById(id)){
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
            }
            this.advertisementService.deleteById(id);
            //int userId = new ObjectMapper().readValue(id);
        }catch(Exception e){
            System.out.print(e);
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseEntity.ok(HttpStatus.OK);
    }


    @RequestMapping(value = "/{advertisementName}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity deleteAdByAdvertisementName(@PathVariable String advertisementName) {
        if (!this.advertisementService.checkAdvertisementExistence(advertisementName)) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        this.advertisementService.deleteByAdvertisementName(advertisementName);
        return new ResponseEntity(HttpStatus.OK);
    }

}
