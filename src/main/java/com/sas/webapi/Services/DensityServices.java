package com.sas.webapi.Services;

import com.sas.webapi.Model.Density;
import com.sas.webapi.Repository.DensityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Pınar Köroğlu on 10.03.2018.
 */
@Service
public class DensityServices {

    @Autowired
    DensityRepository densityRepository;

    public List<Density> getAll() {
        return this.densityRepository.findAll();
    }
    public void save(Density density){
       this.densityRepository.save(density);
    }
    public Density getDensity(Date created_at){return this.densityRepository.findDensityByDate(created_at);}
    public void CountOfMen(Date created_at) {
        this.densityRepository.CountOfMen(created_at);
    }
    public void CountOfWomen(Date created_at) {
        this.densityRepository.CountOfWomen(created_at);
    }

}
