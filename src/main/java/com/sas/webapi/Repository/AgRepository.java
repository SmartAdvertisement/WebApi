package com.sas.webapi.Repository;

import com.sas.webapi.Model.Advertisement;
import com.sas.webapi.Model.AgProgramlama;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Pınar Köroğlu on 4.04.2018.
 */
public interface AgRepository extends JpaRepository<AgProgramlama,Integer> {


}
