package com.sas.webapi.Services;

import com.sas.webapi.Model.Gender;
import com.sas.webapi.Repository.GenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenderServices {

    @Autowired
    GenderRepository genderRepository;

    public List<Gender> getAll() {
        return this.genderRepository.findAll();
    }

    public Gender getById(int id ){

        return this.genderRepository.findById(id);

    }

}
