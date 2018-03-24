package com.sas.webapi.Services;

import com.sas.webapi.Repository.DensityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.util.calendar.LocalGregorianCalendar;

import java.util.Date;

/**
 * Created by Pınar Köroğlu on 10.03.2018.
 */
@Service
public class DensityServices {

    @Autowired
    DensityRepository densityRepository;

    public void CountOfMen(Date created_at) {
        this.densityRepository.CountOfMen(created_at);
    }
    public void CountOfWomen(Date created_at) {
        this.densityRepository.CountOfWomen(created_at);
    }

}
