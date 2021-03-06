package com.sas.webapi.Services;


import com.sas.webapi.Repository.UsersRepository;
import com.sas.webapi.Model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {

    @Autowired
    private UsersRepository userRepository;

    public List<Users> getAll() {
        return this.userRepository.findAll();
    }

    public boolean checkUserExistenceById(int id) {
        return this.userRepository.checkUserExistenceById(id) !=null;
    }

    public boolean checkUserExistence(String username) {
        return this.userRepository.checkUserExistence(username) != null;
    }


    public Users getUser(int id){return this.userRepository.findUsersById(id);}

    public Optional<Users> getByUsername(String username) {
        return this.userRepository.findUserByUsername(username);
    }

    public void save(Users user) {
        this.userRepository.save(user);
    }

    public void deleteById(int id) {
        this.userRepository.deleteById(id);
    }

    public void deleteByUsername(String username) {
        this.userRepository.deleteUserByUsername(username);
    }

}
