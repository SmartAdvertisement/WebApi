package com.sas.webapi.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sas.webapi.Services.BusServices;
import com.sas.webapi.Model.Bus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Pınar Köroğlu on 10.03.2018.
 */
@RestController
@RequestMapping("/bus")
public class BusController {

    @Autowired
    private BusServices busService;

    @RequestMapping
    public List<Bus> getAll() {
        return this.busService.getAll();
    }

    @ResponseBody
    @RequestMapping(method= RequestMethod.POST)
    public ResponseEntity addBus(@RequestBody String jsonBus){
        try{
            Bus bus = new ObjectMapper().readValue(jsonBus,Bus.class);
            this.busService.save(bus);

        }catch (Exception e){

            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity deleteById(@PathVariable int id){
        try{
            if(!this.busService.checkBusExistenceById(id)){
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
            }
            this.busService.deleteById(id);
            //int userId = new ObjectMapper().readValue(id);
        }catch(Exception e){
            System.out.print(e);
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseEntity.ok(HttpStatus.OK);
    }


    @RequestMapping(value = "/{busName}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity deleteBusByBusName(@PathVariable String busName) {
        if (!this.busService.checkBusExistence(busName)) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        this.busService.deleteByBusName(busName);
        return new ResponseEntity(HttpStatus.OK);
    }
}
