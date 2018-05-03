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
import com.sas.webapi.Services.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.criteria.CriteriaBuilder;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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

    @Autowired
    private GenderServices genderServices;

    @Autowired
    private PlaylistService playlistService;

    @RequestMapping
    public List<Advertisement> getAll() {
        return this.advertisementService.getAll();
    }



    @RequestMapping(value = "/uploadfile", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> uploadFile(@RequestParam("uploadFile") MultipartFile file,
                                        @RequestParam("advertisementName") String advertisementName,
                                        @RequestParam("corporationName") String corporationName,
                                        @RequestParam("type") String type,
                                        @RequestParam("durationTime") String durationTime,
                                        @RequestParam("categoryName") String categoryName)throws IOException{
        Advertisement advertisement = new Advertisement();
        AdvertisementCategory category;
        AdvertisementCategory category1;
        category = categoryServices.getById(Integer.parseInt(categoryName));

        File convertFile = new File("C:\\uploaded-files\\"+category.getCategoryName()+"\\"+category.getGender().getName()+"\\"+file.getOriginalFilename());
        if(type.equals("video")){
            advertisement.setVideo(convertFile.getPath());
        }else if(type.equals("photo")){
            advertisement.setPhoto(convertFile.getPath());
        }
        convertFile.createNewFile();
        FileOutputStream fout = new FileOutputStream(convertFile);
        fout.write(file.getBytes());
        fout.close();


        //category1=categoryServices.getById(Integer.parseInt());
        advertisement.setAdvertisement_Name(advertisementName);
        advertisement.setDurationTime(Integer.parseInt(durationTime));
        advertisement.setCorporation_Name(corporationName);
        advertisement.setAdvertisementCategory(category);
        this.advertisementService.save(advertisement);


        //Eğer save'de sıkıntı oluşmadıysa alt kısım çalışır
        //Version değeri arttırılır.
      //  playlistService.increaseVersion();
        return new ResponseEntity<>("File is uploaded successfully",HttpStatus.OK);
    }





    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity deleteById(@PathVariable int id){
        try{
            if(!this.advertisementService.checkAdvertisementExistenceById(id)){
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
            }
            this.advertisementService.deleteById(id);
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