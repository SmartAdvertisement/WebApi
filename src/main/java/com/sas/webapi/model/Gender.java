package com.sas.webapi.model;


import javax.persistence.*;


@Entity
public class Gender {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="name")
    private String name;

  //  private Set<AdvertisementCategory> advertisementCategory = new HashSet<AdvertisementCategory>(0);


    /** get and set **/
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
