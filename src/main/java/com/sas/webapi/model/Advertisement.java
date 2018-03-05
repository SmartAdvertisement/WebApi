package com.sas.webapi.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Pınar Köroğlu on 3.03.2018.
 */
@Entity
@Table(name="advertisement")
public class Advertisement {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="advertisementID")
    private int advertisementID;

    @Column(name="corporation_name")
    private String corporation_Name;

    @Column(name="durationTime")
    private int durationTime;

    @Column(name="advertisementName")
    private String advertisement_Name;


    @Column(name="advertisementKind")
    private String advertisement_Kind;

    @Column(name="created-at")
    private Date created_at;

    @Column(name="updated-at")
    private Date updated_at;

    @ManyToOne
    @JoinColumn(name="categoryID")
    private AdvertisementCategory advertisementCategory;

    /** get and set **/
    public int getAdvertisementID() {
        return advertisementID;
    }

    public void setAdvertisementID(int advertisementID) {
        this.advertisementID = advertisementID;
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

    public String getAdvertisement_Kind() {
        return advertisement_Kind;
    }

    public void setAdvertisement_Kind(String advertisement_Kind) {
        this.advertisement_Kind = advertisement_Kind;
    }

    public AdvertisementCategory getAdvertisementCategory() {
        return advertisementCategory;
    }

    public void setAdvertisementCategory(AdvertisementCategory advertisementCategory) {
        this.advertisementCategory = advertisementCategory;
    }

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
