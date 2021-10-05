package com.example.hotel.model.entities;


import com.sun.istack.NotNull;
import org.hibernate.annotations.NotFound;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="hotels")

public class HotelsEntity implements Serializable {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idHotel;


    @Basic
    private String nom;


    @Basic
    private String adresseHotel;

    @Basic
    private int nbEtoile;

    @Basic
    private String ville;

    @Basic
    private String telephoneHotel;

    @Basic
    private String emailHotel ;

    public int getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(int idHotel) {
        this.idHotel = idHotel;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresseHotel() {
        return adresseHotel;
    }

    public void setAdresseHotel(String adresseHotel) {
        this.adresseHotel = adresseHotel;
    }

    public int getNbEtoile() {
        return nbEtoile;
    }

    public void setNbEtoile(int nbEtoile) {
        this.nbEtoile = nbEtoile;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getTelephoneHotel() {
        return telephoneHotel;
    }

    public void setTelephoneHotel(String telephoneHotel) {
        this.telephoneHotel = telephoneHotel;
    }

    public String getEmailHotel() {
        return emailHotel;
    }

    public void setEmail(String emailHotel) {
        this.emailHotel = emailHotel;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HotelsEntity)) return false;
        HotelsEntity that = (HotelsEntity) o;
        return getIdHotel() == that.getIdHotel() && getNbEtoile() == that.getNbEtoile() && Objects.equals(getNom(), that.getNom()) && Objects.equals(getAdresseHotel(), that.getAdresseHotel()) && Objects.equals(getVille(), that.getVille()) && Objects.equals(getTelephoneHotel(), that.getTelephoneHotel()) && Objects.equals(getEmailHotel(), that.getEmailHotel());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdHotel(), getNom(), getAdresseHotel(), getNbEtoile(), getVille(), getTelephoneHotel(), getEmailHotel());
    }
}
