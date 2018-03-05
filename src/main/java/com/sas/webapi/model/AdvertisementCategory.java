package com.sas.webapi.model;

import com.sun.javafx.beans.IDProperty;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Pınar Köroğlu on 4.03.2018.
 */
@Entity
public class AdvertisementCategory {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int categoryID;
    private String categoryName;
    @ManyToOne
    @JoinColumn(name="genderID")
    private List<Gender> genderID;

    /** get and set **/

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Gender> getGenderID() {
        return genderID;
    }

    public void setGenderID(List<Gender> genderID) {
        this.genderID = genderID;
    }
}
