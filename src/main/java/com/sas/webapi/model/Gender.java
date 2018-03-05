package com.sas.webapi.model;

import com.sun.javafx.beans.IDProperty;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * Created by Pınar Köroğlu on 4.03.2018.
 */
@Entity
public class Gender {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int genderID;
    private String genderName;

    /** get and set **/
    public int getGenderID() {
        return genderID;
    }

    public void setGenderID(int genderID) {
        this.genderID = genderID;
    }

    public String getGenderName() {
        return genderName;
    }

    public void setGenderName(String genderName) {
        this.genderName = genderName;
    }
}
