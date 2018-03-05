package com.sas.webapi.model;

import com.sun.javafx.beans.IDProperty;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Pınar Köroğlu on 3.03.2018.
 */
@Entity
public class Density {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int densityID;
    private int count_of_men;
    private int count_of_women;
    private int latitude;
    private int longidude;
    private int average_age;
    private Date created;
    private Date updated;
    @ManyToOne
    @JoinColumn(name="busID")
    private Bus busDensity;

    /** get and set **/
    public int getDensityID() {
        return densityID;
    }

    public void setDensityID(int densityID) {
        this.densityID = densityID;
    }

    public int getCount_of_men() {
        return count_of_men;
    }

    public void setCount_of_men(int count_of_men) {
        this.count_of_men = count_of_men;
    }

    public int getCount_of_women() {
        return count_of_women;
    }

    public void setCount_of_women(int count_of_women) {
        this.count_of_women = count_of_women;
    }

    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public int getLongidude() {
        return longidude;
    }

    public void setLongidude(int longidude) {
        this.longidude = longidude;
    }

    public int getAverage_age() {
        return average_age;
    }

    public void setAverage_age(int average_age) {
        this.average_age = average_age;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Bus getBusDensity() {
        return busDensity;
    }

    public void setBusDensity(Bus busDensity) {
        this.busDensity = busDensity;
    }
}
