package com.sas.webapi.Services;

import com.sas.webapi.Repository.CategoryRepository;
import com.sas.webapi.Repository.DensityRepository;
import com.sas.webapi.model.AdvertisementCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Pınar Köroğlu on 10.03.2018.
 */
@Service
public class DensityServices {
    /*
    @Autowired
    DensityRepository densityRepository;

    public List<AdvertisementCategory> getAll() {
        return this.densityRepository.findAll();
    }

    public boolean checkCategoryExistenceById(int id) {
        return this.densityRepository.checkCategoryExistenceById(id) !=null;
    }

    public AdvertisementCategory getByAdvertisementName(String advertisement_Name) {
        return this.densityRepository.findCategoryByCategoryName(advertisement_Name);
    }

    public void save(AdvertisementCategory advertisementCategory) {
        this.densityRepository.save(advertisementCategory);
    }

    public void deleteById(int id) {
        this.densityRepository.deleteById(id);
    }
*/

}
