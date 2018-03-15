package com.sas.webapi.Repository;

import com.sas.webapi.model.Advertisement;
import com.sas.webapi.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

/**
 * Created by Pınar Köroğlu on 10.03.2018.
 */
public interface AdvertisementRepository extends JpaRepository<Advertisement,Integer> {

    @Query("SELECT u FROM Advertisement u WHERE u.advertisement_Name = :advertisementName")
    Advertisement findAdByAdvertisementName(@Param("advertisementName") String advertisementName);

    @Query("SELECT 1 FROM Advertisement u WHERE u.id = :id")
    Integer checkAdvertisementExistenceById(@Param("id") int id);

    @Query("SELECT 1 FROM Advertisement u WHERE u.advertisement_Name= :advertisementName")
    Integer checkAdvertisementExistence(@Param("advertisementName") String advertisementName);

    @Transactional
    @Modifying
    @Query("DELETE FROM Advertisement u WHERE u.advertisement_Name = :advertisementName")
    void deleteAdByAdvertisementName(@Param("advertisementName") String advertisementName);

}
