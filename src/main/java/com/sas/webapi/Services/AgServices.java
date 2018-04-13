package com.sas.webapi.Services;

import com.sas.webapi.Model.Advertisement;
import com.sas.webapi.Model.AgProgramlama;
import com.sas.webapi.Repository.AdvertisementRepository;
import com.sas.webapi.Repository.AgRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Service
public class AgServices {

    @Autowired
    AgRepository agRepository;

    public List<AgProgramlama> getAll() {
        return this.agRepository.findAll();

    }

    public void update(AgProgramlama agProgramlama) {
        save(agProgramlama);
    }

    public void delete(Integer ID) {
        this.agRepository.deleteById(ID);
    }

    public void save(AgProgramlama agProgramlama) {
        try{
            this.agRepository.save(agProgramlama);
        }catch(Exception e){
            System.out.print(e);
        }

    }


}
