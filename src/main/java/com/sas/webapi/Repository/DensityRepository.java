package com.sas.webapi.Repository;

import com.sas.webapi.Model.Density;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Date;

/**
 * Created by Pınar Köroğlu on 10.03.2018.
 */
public interface DensityRepository extends JpaRepository<Density,Integer> {

    @Query("SELECT 1 FROM Density u WHERE u.id = :id")
    Integer checkDensityExistenceById(@Param("id") Integer id);

    @Transactional
    @Modifying
    @Query("DELETE FROM Density u WHERE u.id = :id")
    void deleteDensityByDensityId(@Param("id") Integer id);


    @Query("SELECT u.count_of_men FROM Density u WHERE u.created_at= :created_at")
    void CountOfMen(@Param("created_at") Date created_at);

    @Query("SELECT u.count_of_women FROM Density u WHERE u.created_at= :created_at")
    void CountOfWomen(@Param("created_at") Date created_at);

    @Query("SELECT u FROM Density u WHERE u.created_at = :created_at ")
    Density findDensityByDate(@Param("created_at") Date created_at);
}
