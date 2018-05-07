package com.sas.webapi.Model;

import javax.persistence.*;

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
    @Column(name = "maxAge")
    private Integer maxage;
    @Column(name = "minAge")
    private Integer minage;


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


    public Integer getMaxage() {
        return maxage;
    }

    public void setMaxage(Integer maxage) {
        this.maxage = maxage;
    }

    public Integer getMinage() {
        return minage;
    }

    public void setMinage(Integer minage) {
        this.minage = minage;
    }
}
