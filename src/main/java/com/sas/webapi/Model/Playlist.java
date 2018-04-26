package com.sas.webapi.Model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Playlist")
public class Playlist {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="Version")
    private int version;

    @Column(name="ActiveStatus")
    private boolean activeStatus;

    @Column(name="created_at")
    private Date created_at;

    @Column(name="updated_at")
    private Date updated_at;

    @ManyToOne
    @JoinColumn(name="deviceId")
    private Device device;

    public Playlist() {
    }

    public Playlist(int version, boolean activeStatus, Date created_at, Date updated_at, Device device) {
        this.version = version;
        this.activeStatus = activeStatus;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.device = device;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public boolean isActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(boolean activeStatus) {
        this.activeStatus = activeStatus;
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

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }
}
