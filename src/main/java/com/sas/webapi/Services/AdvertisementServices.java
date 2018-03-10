package com.sas.webapi.Services;

import com.sas.webapi.Repository.AdvertisementRepository;
import com.sas.webapi.model.Advertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Pınar Köroğlu on 10.03.2018.
 */
@Service
public class AdvertisementServices {
    @Autowired
    AdvertisementRepository advertisementRepository;

    public List<Advertisement> getAll() {
        return this.advertisementRepository.findAll();
    }

    public boolean checkAdvertisementExistenceById(int id) {
        return this.advertisementRepository.checkAdvertisementExistenceById(id) !=null;
    }

    public boolean checkAdvertisementExistence(String advertisementName) {
        return this.advertisementRepository.checkAdvertisementExistence(advertisementName) != null;
    }

    public Advertisement getByAdvertisementName(String advertisement_Name) {
        return this.advertisementRepository.findAdByAdvertisementName(advertisement_Name);
    }

    public void save(Advertisement advertisement) {
        this.advertisementRepository.save(advertisement);
    }

    public void deleteById(int id) {
        this.advertisementRepository.deleteById(id);
    }

    public void deleteByAdvertisementName(String advertisementName) {
        this.advertisementRepository.deleteAdByAdvertisementName(advertisementName);
    }
}
