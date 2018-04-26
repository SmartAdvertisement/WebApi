package com.sas.webapi.Controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sas.webapi.Model.Gender;
import com.sas.webapi.Services.CategoryServices;
import com.sas.webapi.Model.AdvertisementCategory;
import com.sas.webapi.Services.GenderServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.websocket.Session;
import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * Created by Pınar Köroğlu on 10.03.2018.
 */
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryServices categoryServices;

    @Autowired
    private GenderServices genderServices;

    @RequestMapping
    public List<AdvertisementCategory> getAll() {
        return this.categoryServices.getAll();
    }

    @ResponseBody
    @RequestMapping(value="/add",method= RequestMethod.POST)
    public ResponseEntity addAdvertisementCategory(@RequestBody String jsonCategory){
        Gender gender;
        try{
            ObjectMapper mapper = new ObjectMapper();
            AdvertisementCategory category = new AdvertisementCategory();
            Map<String, Object> carMap = mapper.readValue(jsonCategory, new TypeReference<Map<String, Object>>() {});
            gender = genderServices.getById(Integer.parseInt(carMap.get("gender").toString()));
            category.setGender(gender);
            category.setCategoryName(carMap.get("categoryName").toString());
            this.categoryServices.save(category);

        }catch (Exception e){

            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity deleteById(@PathVariable int id){
        try{
            if(!this.categoryServices.checkCategoryExistenceById(id)){
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
            }
            this.categoryServices.deleteById(id);
            //int userId = new ObjectMapper().readValue(id);
        }catch(Exception e){
            System.out.print(e);
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseEntity.ok(HttpStatus.OK);
    }



}
