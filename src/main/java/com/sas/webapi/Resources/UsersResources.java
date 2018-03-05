package com.sas.webapi.Resources;

import com.sas.webapi.Dto.UsersDto;
import com.sas.webapi.Services.UsersService;
import com.sas.webapi.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.core.Response;



@RestController
@RequestMapping("/users")
public class UsersResources {
//    private UserRepository userRepository;
//    private RequestBody addUserRequest;
//
//    @Autowired
//    public UserController(UserRepository user) {
//        this.userRepository = user;
//    }
//    @RequestMapping(method = RequestMethod.GET)
//    public List<Users> findAllUser() {
//        return userRepository.findAll();
//    }
//
//    @RequestMapping(method = RequestMethod.POST)
//    public void addUser(@RequestBody AddUserRequest addUserRequest) {
//        Users user = new Users();
//        user.setName(addUserRequest.getName());
//        user.setSurname(addUserRequest.getSurname());
//        userRepository.save(user);
//
//    }

    @Autowired
    UsersService usersService;


    public Response saveCity(UsersDto usersDto){
        Users users;

        try{

            users = usersService.saveUsers(users);

        }catch (Exception e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
        return Response.ok(users).build();
    }



}

