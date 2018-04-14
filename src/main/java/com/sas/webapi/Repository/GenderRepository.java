package com.sas.webapi.Repository;

import com.sas.webapi.Model.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface GenderRepository extends JpaRepository<Gender,Integer> {

    @Query("SELECT u FROM Gender u WHERE u.id = :id")
    Gender findById(@Param("id") int id);
}
