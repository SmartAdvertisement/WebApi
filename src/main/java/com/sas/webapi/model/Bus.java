package com.sas.webapi.model;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * Created by Pınar Köroğlu on 4.03.2018.
 */
@Entity
public class Bus {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int busID;
    private String busName;
    private String route;
    private String plate;

    /** get and set **/
    public int getBusID() {
        return busID;
    }

    public void setBusID(int busID) {
        this.busID = busID;
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
