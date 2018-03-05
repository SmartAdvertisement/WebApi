package com.sas.webapi.Services;

import com.sas.webapi.Dao.UsersDao;
import com.sas.webapi.Dto.UsersDto;
import com.sas.webapi.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class UsersService {

    @Autowired
    private UsersDao usersDao;

    @Transactional
    public Users saveUsers(UsersDto usersDto){
        Users users = new Users();
        users.setName(usersDto.getName());
        users.setEmail(usersDto.getEmail());
        users.setSuperUser(usersDto.getSuperUser());
        users.setSurname(usersDto.getSurname());
        users.setPassword(usersDto.getPassword());
        usersDao.save(users);

        return users;
    }

}
