package com.sas.webapi.Model;

import com.sas.webapi.Model.Gender;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

/**
 * Created by Pınar Köroğlu on 4.03.2018.
 */
@Entity
@Table(name="advertisementcategory")
public class AdvertisementCategory {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name="categoryName")
    private String categoryName;

    @ManyToOne
    @JoinColumn(name="genderID")
    private Gender gender;


    /** get and set **/

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
