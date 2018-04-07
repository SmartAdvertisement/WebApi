package com.sas.webapi.model;

import javax.persistence.*;
import java.util.Date;
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

  /*  public AdvertisementCategory getAdvertisementCategory() {
        return advertisementCategory;
    }

    public void setAdvertisementCategory(AdvertisementCategory advertisementCategory) {
        this.advertisementCategory = advertisementCategory;
    }
*/
    public Date getCreated() {
        return created_at;
    }

    public void setCreated(Date created) {
        this.created_at = created;
    }

    public Date getUpdated() {
        return updated_at;
    }

    public void setUpdated(Date updated) {
        this.updated_at = updated;
    }
}
