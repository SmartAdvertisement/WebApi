package com.sas.webapi.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sas.webapi.Services.UsersService;
import com.sas.webapi.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UsersService userService;

    @RequestMapping
    public List<Users> getAll() {
        return this.userService.getAll();
    }

    @ResponseBody
    @RequestMapping(method= RequestMethod.POST)
    public ResponseEntity addUser(@RequestBody String jsonUser){
        try{
            Users user = new ObjectMapper().readValue(jsonUser,Users.class);
            this.userService.save(user);

        }catch (Exception e){

            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity deleteById(@PathVariable int id){
        try{
            if(!this.userService.checkUserExistenceById(id)){
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
            }
            this.userService.deleteById(id);
            //int userId = new ObjectMapper().readValue(id);
        }catch(Exception e){
            System.out.print(e);
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseEntity.ok(HttpStatus.OK);
    }


    @RequestMapping(value = "/{username}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity deleteUserByUsername(@PathVariable String username) {
        if (!this.userService.checkUserExistence(username)) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        this.userService.deleteByUsername(username);
        return new ResponseEntity(HttpStatus.OK);
    }


}

