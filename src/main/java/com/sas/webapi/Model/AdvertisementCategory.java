package com.sas.webapi.Model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Pınar Köroğlu on 4.03.2018.
 */
@Entity
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

    @OneToMany(fetch=FetchType.EAGER)
    @JoinColumn(name="Advertisement_Category")
    private List<Advertisement> advertisements;
    /** get and set **/

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Advertisement> getAdvertisements() {
        return advertisements;
    }

    public void setAdvertisements(List<Advertisement> advertisements) {
        this.advertisements = advertisements;
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
