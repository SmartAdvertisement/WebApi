package com.sas.webapi.model;

import javax.persistence.*;

/**
 * Created by Pınar Köroğlu on 4.03.2018.
 */
@Entity
public class AdvertisementCategory {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String categoryName;

    @ManyToOne
    @JoinColumn(name="genderID")

    private Gender gender;


    /** get and set **/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

   /* @JoinColumn(name="id",nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }*/
}
