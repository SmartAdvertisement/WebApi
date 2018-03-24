package com.sas.webapi.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sas.webapi.Repository.RoleRepository;
import com.sas.webapi.Services.UsersService;
import com.sas.webapi.Model.Users;
import com.sas.webapi.Model.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;


@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UsersService userService;

    @Autowired
    private RoleRepository roleRepository;

    @RequestMapping
    public List<Users> getAll() {
        return this.userService.getAll();
    }

    @GetMapping(value ="/{id}" ,produces = "application/json")
    @ResponseBody
    public ResponseEntity<?> getUserById(@PathVariable int id){
        Users user = this.userService.getUser(id);
        if(user==null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(user);
    }

    @ResponseBody
    @RequestMapping(method= RequestMethod.POST)
    @JsonDeserialize(as = Users.class)
    public ResponseEntity addUser(@RequestBody String jsonUser){
        try{
            Users user = new ObjectMapper().readValue(jsonUser,Users.class);
            user.setActive(1);
            Roles userRole = roleRepository.findRolesById(1);
            user.setRoles(new HashSet<>(Arrays.asList(userRole)));
            this.userService.save(user);

        }catch (Exception e){
            System.out.print(e);
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

