package com.sas.webapi.Repository;

import com.sas.webapi.model.AdvertisementCategory;
import com.sas.webapi.model.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Pınar Köroğlu on 10.03.2018.
 */
public interface BusRepository extends JpaRepository<Bus,Integer> {

    @Query("SELECT u FROM Bus u WHERE u.plate = :plate")
    Bus findBusByBusName(@Param("plate") String plate);

    @Query("SELECT 1 FROM Bus u WHERE u.id = :id")
    Integer checkBusExistenceById(@Param("id") int id);

    @Query("SELECT 1 FROM Bus u WHERE u.plate= :plate")
    Integer checkBusExistence(@Param("plate") String plate);

    @Transactional
    @Modifying
    @Query("DELETE FROM Bus u WHERE u.plate = :plate")
    void deleteBusByBusName(@Param("plate") String plate);
}
