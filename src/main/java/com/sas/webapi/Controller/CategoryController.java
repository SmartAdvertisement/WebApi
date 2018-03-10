package com.sas.webapi.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sas.webapi.Services.BusServices;
import com.sas.webapi.Services.CategoryServices;
import com.sas.webapi.model.AdvertisementCategory;
import com.sas.webapi.model.Bus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Pınar Köroğlu on 10.03.2018.
 */
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryServices categoryServices;

    @RequestMapping
    public List<AdvertisementCategory> getAll() {
        return this.categoryServices.getAll();
    }

    @ResponseBody
    @RequestMapping(method= RequestMethod.POST)
    public ResponseEntity addAdvertisementCategory(@RequestBody String jsonCategory){
        try{
            AdvertisementCategory category = new ObjectMapper().readValue(jsonCategory,AdvertisementCategory.class);
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


    @RequestMapping(value = "/{busName}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity deleteBusByBusName(@PathVariable String categoryName) {
        if (!this.categoryServices.checkCategoryExistence(categoryName)) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        this.categoryServices.deleteByAdvertisementname(categoryName);
        return new ResponseEntity(HttpStatus.OK);
    }
}
