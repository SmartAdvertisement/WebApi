package com.sas.webapi.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Pınar Köroğlu on 4.03.2018.
 */
@Entity
@Table(name="Bus")
public class Bus implements Serializable{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    private String busName;

    private String route;

    private String plate;

    /** get and set **/
    public int getId() {
        return id;
    }

    public void setId(int id) {
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
