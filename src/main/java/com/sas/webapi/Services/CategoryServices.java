package com.sas.webapi.Services;

import com.sas.webapi.Repository.CategoryRepository;
import com.sas.webapi.Model.AdvertisementCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Pınar Köroğlu on 10.03.2018.
 */
@Service
public class CategoryServices {
    @Autowired
    CategoryRepository categoryRepository;

    public List<AdvertisementCategory> getAll() {
        return this.categoryRepository.findAll();
    }

    public boolean checkCategoryExistenceById(int id) {
        return this.categoryRepository.checkCategoryExistenceById(id) !=null;
    }

    public boolean checkCategoryExistence(String advertisement_Name) {
        return this.categoryRepository.checkCategoryExistence(advertisement_Name) != null;
    }

    public AdvertisementCategory getByAdvertisementName(String advertisement_Name) {
        return this.categoryRepository.findCategoryByCategoryName(advertisement_Name);
    }

    public void save(AdvertisementCategory advertisementCategory) {
        this.categoryRepository.save(advertisementCategory);
    }

    public void deleteById(int id) {
        this.categoryRepository.deleteById(id);
    }

    public void deleteByAdvertisementname(String categoryName) {
        this.categoryRepository.deleteCategoryByCategoryName(categoryName);
    }
}
