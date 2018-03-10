package com.sas.webapi.model;


import javax.persistence.*;
import java.util.Date;

/**
 * Created by Pınar Köroğlu on 3.03.2018.
 */
@Entity
public class Density {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="densityID")
    private Integer id;

    @Column(name="count_of_men")
    private int count_of_men;

    @Column(name="count_of_women")
    private int count_of_women;

    @Column(name="latitude")
    private int latitude;

    @Column(name="longitude")
    private int longidude;

    @Column(name="average_age")
    private int average_age;

    @Column(name="created_at")
    private Date created_at;

    @Column(name="updated_at")
    private Date updated_at;


    //private Bus bus;

    @PrePersist
    protected void onCreate() {
        created_at = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        updated_at = new Date();
    }

    /** get and set **/
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

   /* @ManyToOne
    @JoinColumn(name="busID")
    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }*/
}
