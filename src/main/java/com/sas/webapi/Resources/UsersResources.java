package com.sas.webapi.Resources;

import com.sas.webapi.Dto.UsersDto;
import com.sas.webapi.Services.UsersService;
import com.sas.webapi.model.Users;
import org.apache.logging.log4j.util.PerformanceSensitive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;



@Component
@Path("/users")
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

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveCity(UsersDto usersDto){
        Users users;

        try{
            users = usersService.saveUsers(usersDto);

        }catch (Exception e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
        return Response.ok(users).build();
    }



}

