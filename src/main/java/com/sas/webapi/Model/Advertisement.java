package com.sas.webapi.Model;

import com.sas.webapi.Model.AdvertisementCategory;

import javax.persistence.*;
import java.net.Inet4Address;
import java.util.Date;

/**
 * Created by Pınar Köroğlu on 3.03.2018.
 */
@Entity
@Table(name="advertisement")
public class Advertisement {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="corporation_name")
    private String corporation_Name;

    @Column(name="duration_time")
    private int durationTime;

    @Column(name="advertisement_name")
    private String advertisement_Name;

    @Column(name="video")
    private String video;

    @Column(name="photo")
    private String photo;

    @Column(name="created_at")
    private Date created_at;

    @Column(name="updated_at")
    private Date updated_at;

    @ManyToOne
    @JoinColumn(name="categoryID")
    private AdvertisementCategory advertisementCategory;



    @PrePersist
    protected void onCreate() {
        created_at = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        updated_at = new Date();
    }

    public Advertisement(){

    }

    public Advertisement(Advertisement advertisement){
        this.corporation_Name=advertisement.getCorporation_Name();
         this.advertisement_Name=advertisement.getAdvertisement_Name();
        this.durationTime=advertisement.getDurationTime();
        this.photo=advertisement.getPhoto();
        this.video=advertisement.getVideo();
    }
    /** get and set **/

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getCorporation_Name() {
        return corporation_Name;
    }

    public void setCorporation_Name(String corporation_Name) {
        this.corporation_Name = corporation_Name;
    }

    public int getDurationTime() {
        return durationTime;
    }

    public void setDurationTime(int durationTime) {
        this.durationTime = durationTime;
    }

    public String getAdvertisement_Name() {
        return advertisement_Name;
    }

    public void setAdvertisement_Name(String advertisement_Name) {
        this.advertisement_Name = advertisement_Name;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public AdvertisementCategory getAdvertisementCategory() {
        return advertisementCategory;
    }

    public void setAdvertisementCategory(AdvertisementCategory advertisementCategory) {
        this.advertisementCategory = advertisementCategory;
    }


}
