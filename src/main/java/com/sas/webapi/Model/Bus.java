package com.sas.webapi.Model;

import javax.persistence.*;

/**
 * Created by Pınar Köroğlu on 4.03.2018.
 */
@Entity
@Table(name="Bus")
public class Bus{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="busName")
    private String busName;

    @Column(name="route")
    private String route;

    @Column(name="plate")
    private String plate;


    /** get and set **/
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBusName() {
        return busName;
    }

    public void setBusName(String busName) {
        this.busName = busName;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }
}
