package com.sas.webapi.Services;

import com.sas.webapi.Model.Advertisement;
import com.sas.webapi.Model.AgProgramlama;
import com.sas.webapi.Repository.AdvertisementRepository;
import com.sas.webapi.Repository.AgRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

/**
 * Created by Pınar Köroğlu on 4.04.2018.
 */
@Service
public class AgServices {

    @Autowired
    AgRepository agRepository;

    public List<AgProgramlama> getAll() {
        return this.agRepository.findAll();
    }

    public void update(AgProgramlama agProgramlama,Integer ID) {
        boolean exist = agRepository.existsById(ID);
        if (exist) {
            delete(ID);
            save(agProgramlama);

        } else {
            save(agProgramlama);
        }
    }

    public void delete(Integer ID) {
        this.agRepository.deleteById(ID);
    }

    public void save(AgProgramlama agProgramlama) {
        this.agRepository.save(agProgramlama);
    }


}
