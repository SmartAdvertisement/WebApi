package com.sas.webapi.Model;

import javax.persistence.*;

/**
 * Created by Pınar Köroğlu on 4.04.2018.
 */
@Entity
@Table(name="AgProgramlama")
public class AgProgramlama  {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="agID")
    private Integer agID;

    @Column(name="dersinKodu")
    private Integer dersinKodu;

    @Column(name="dersinAdi")
    private String dersinAdi;

    @Column(name="dersinİcerigi")
    private String dersinİcerigi;

    public AgProgramlama(Integer dersinKodu,String dersinAdi,String dersinİcerigi){
        this.dersinAdi=dersinAdi;
        this.dersinKodu=dersinKodu;
        this.dersinİcerigi=dersinİcerigi;
    }
    public Integer getAgID() {
        return agID;
    }

    public void setAgID(Integer agID) {
        this.agID = agID;
    }

    public Integer getDersinKodu() {
        return dersinKodu;
    }

    public void setDersinKodu(Integer dersinKodu) {
        this.dersinKodu = dersinKodu;
    }

    public String getDersinAdi() {
        return dersinAdi;
    }

    public void setDersinAdi(String dersinAdi) {
        this.dersinAdi = dersinAdi;
    }

    public String getDersinİcerigi() {
        return dersinİcerigi;
    }

    public void setDersinİcerigi(String dersinİcerigi) {
        this.dersinİcerigi = dersinİcerigi;
    }
}
