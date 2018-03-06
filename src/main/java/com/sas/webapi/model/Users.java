package com.sas.webapi.model;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="users")
public class Users {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name="surname")
    private String surname;

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    @Column(name="is_super_user")
    private Boolean isSuperUser;

    @Column(name="email")
    private String email;


    @Column(name="created_at")
    private Date created_at;

    @Column(name="updated_at")
    private Date updated_at;


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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Boolean getSuperUser() {
        return isSuperUser;
    }

    public void setSuperUser(Boolean superUser) {
        isSuperUser = superUser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
