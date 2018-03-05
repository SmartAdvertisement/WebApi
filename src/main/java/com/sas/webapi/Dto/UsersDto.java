package com.sas.webapi.Dto;

import com.sas.webapi.model.Users;

import java.util.Date;

public class UsersDto {

    private Integer id;
    private String name;
    private String surname;
    private String username;
    private Boolean isSuperUser;
    private String email;
    private String password;
    private Date created_at;
    private Date updated_at;


    public UsersDto(){

    }

    public UsersDto(Users users){
        this.id = users.getId();
        this.name = users.getName();
        this.surname = users.getSurname();
        this.email = users.getEmail();
        this.isSuperUser = users.getSuperUser();
        this.username = users.getUsername();
        this.password = users.getPassword();
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
}
