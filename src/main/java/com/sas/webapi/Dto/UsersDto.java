package com.sas.webapi.Dto;

import com.sas.webapi.model.Users;

import java.util.Date;

public class UsersDto {

    private Long id;
    private String name;
    private String surname;
    private String username;
    private Boolean isSuperUser;
    private String email;
    private String password;
    private Date created;
    private Date updated;


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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
