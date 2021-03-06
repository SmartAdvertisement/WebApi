package com.sas.webapi.Services;

import com.sas.webapi.Repository.UsersRepository;
import com.sas.webapi.Model.CustomUserDetails;
import com.sas.webapi.Model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService{

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> optionalUsers = usersRepository.findUserByUsername(username);
        optionalUsers.orElseThrow(
                () -> new UsernameNotFoundException("Kullanıcı adı bulunamadı!"));
        return optionalUsers
                .map(CustomUserDetails::new).get();


    }
}
