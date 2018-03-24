package com.sas.webapi.Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="roles")
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="role_id")
    private int id;

    @Column(name="role")
    private String role;

    @OneToMany(fetch=FetchType.EAGER)
    @JoinColumn(name="Urun_Role")
    private List<Users> users;

    /*get set */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }
}
