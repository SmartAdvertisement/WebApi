package com.sas.webapi.Repository;

import com.sas.webapi.Model.Density;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

/**
 * Created by Pınar Köroğlu on 10.03.2018.
 */
public interface DensityRepository extends JpaRepository<Density,Integer> {

    @Query("SELECT 1 FROM Density u WHERE u.id = :id")
    Integer checkDensityExistenceById(@Param("id") int id);

    @Transactional
    @Modifying
    @Query("DELETE FROM Density u WHERE u.id = :id")
    void deleteDensityByDensityId(@Param("id") Integer id);
}
