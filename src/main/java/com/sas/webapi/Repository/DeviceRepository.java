package com.sas.webapi.Repository;

import com.sas.webapi.Model.AgProgramlama;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository  extends JpaRepository<AgProgramlama,Integer> {

}
