package com.sas.webapi.Services;

import com.sas.webapi.Repository.AdvertisementRepository;
import com.sas.webapi.Repository.BusRepository;
import com.sas.webapi.model.Advertisement;
import com.sas.webapi.model.Bus;
import org.hibernate.query.criteria.internal.BasicPathUsageException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Pınar Köroğlu on 10.03.2018.
 */
@Service
public class BusServices {
    @Autowired
    BusRepository busRepository;

    public List<Bus> getAll() {
        return this.busRepository.findAll();
    }

    public boolean checkBusExistenceById(int id) {
        return this.busRepository.checkBusExistenceById(id) !=null;
    }

    public boolean checkBusExistence(String advertisement_Name) {
        return this.busRepository.checkBusExistence(advertisement_Name) != null;
    }

    public Bus getByAdvertisementName(String busName) {
        return this.busRepository.findBusByBusName(busName);
    }

    public void save(Bus bus) {
        this.busRepository.save(bus);
    }

    public void deleteById(int id) {
        this.busRepository.deleteById(id);
    }

    public void deleteByBusName(String busName) {
        this.busRepository.deleteBusByBusName(busName);
    }
}
