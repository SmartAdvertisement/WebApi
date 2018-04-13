package com.sas.webapi.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="ag_programlama")
public class AgProgramlama implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="agid")
    private Integer agID;

    @JsonProperty("dersin_kodu")
    @Column(name="dersin_kodu")
    private String dersinKodu;

    @JsonProperty("dersin_adi")
    @Column(name="dersin_adi")
    private String dersinAdi;

    @JsonProperty("dersin_icerigi")
    @Column(name="dersin_icerigi")
    private String dersinIcerigi;

    public AgProgramlama(){
    }

    public Integer getAgID() {
        return agID;
    }

    public void setAgID(Integer agID) {
        this.agID = agID;
    }

    public String getDersinKodu() {
        return dersinKodu;
    }

    public void setDersinKodu(String dersinKodu) {
        this.dersinKodu = dersinKodu;
    }

    public String getDersinAdi() {
        return dersinAdi;
    }

    public void setDersinAdi(String dersinAdi) {
        this.dersinAdi = dersinAdi;
    }

    public String getDersinIcerigi() {
        return dersinIcerigi;
    }

    public void setDersinIcerigi(String dersinIcerigi) {
        this.dersinIcerigi = dersinIcerigi;
    }
}
