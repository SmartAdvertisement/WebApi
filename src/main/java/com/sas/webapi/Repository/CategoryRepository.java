package com.sas.webapi.Repository;

import com.sas.webapi.Model.AdvertisementCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

/**
 * Created by Pınar Köroğlu on 10.03.2018.
 */
public interface CategoryRepository extends JpaRepository<AdvertisementCategory,Integer> {
    @Query("SELECT u FROM AdvertisementCategory u WHERE u.categoryName = :categoryName")
    AdvertisementCategory findCategoryByCategoryName(@Param("categoryName") String categoryName);

    @Query("SELECT 1 FROM AdvertisementCategory u WHERE u.id = :id")
    Integer checkCategoryExistenceById(@Param("id") int id);

    @Query("SELECT 1 FROM AdvertisementCategory u WHERE u.categoryName= :categoryName")
    Integer checkCategoryExistence(@Param("categoryName") String categoryName);

    @Transactional
    @Modifying
    @Query("DELETE FROM AdvertisementCategory u WHERE u.categoryName = :categoryName")
    void deleteCategoryByCategoryName(@Param("categoryName") String categoryName);

}
