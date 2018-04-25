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
    private Integer maxAge;
    @Column(name = "minAge")
    private Integer minAge;


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


    public Integer getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(Integer maxAge) {
        this.maxAge = maxAge;
    }

    public Integer getMinAge() {
        return minAge;
    }

    public void setMinAge(Integer minAge) {
        this.minAge = minAge;
    }
}
