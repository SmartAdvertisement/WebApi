package com.sas.webapi.Controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sas.webapi.Model.AdvertisementCategory;
import com.sas.webapi.Model.Gender;
import com.sas.webapi.Model.Users;
import com.sas.webapi.Repository.CategoryRepository;
import com.sas.webapi.Services.AdvertisementServices;
import com.sas.webapi.Model.Advertisement;
import com.sas.webapi.Services.CategoryServices;
import com.sas.webapi.Services.GenderServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

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

    @Autowired
    private CategoryServices categoryServices;


    @RequestMapping
    public List<Advertisement> getAll() {
        return this.advertisementService.getAll();
    }

    @ResponseBody
    @RequestMapping(value="/add",method= RequestMethod.POST)
    @JsonDeserialize(as=Advertisement.class)
    public ResponseEntity addAdvertisement(@RequestBody String json){
        try{
            AdvertisementCategory category;
            Advertisement advertisement = new Advertisement();
            ObjectMapper mapper = new ObjectMapper();
            Map<String, Object> objMap = mapper.readValue(json, new TypeReference<Map<String, Object>>() {});
            category = categoryServices.getById(Integer.parseInt(objMap.get("advertisementCategory").toString()));
            advertisement.setAdvertisementCategory(category);
            advertisement.setAdvertisement_Name(objMap.get("advertisement_Name").toString());
            advertisement.setCorporation_Name(objMap.get("corporation_Name").toString());
            advertisement.setPhoto(objMap.get("photo").toString());
            advertisement.setDurationTime(Integer.parseInt(objMap.get("durationTime").toString()));
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
