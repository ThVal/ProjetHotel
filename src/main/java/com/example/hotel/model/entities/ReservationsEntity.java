package com.example.hotel.model.entities;

import com.sun.istack.NotNull;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;


@Entity
@Table(name="reservations")

public class ReservationsEntity implements Serializable {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReservation;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "idClient")
    private ClientsEntity client;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "idHotel")
    private HotelsEntity hotel;

    @Basic
    private Date dateDebut;

    @Basic
    private Date dateFin;

    @Basic
    private int numChambre;

    public Integer getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }

    public ClientsEntity getClient() {
        return client;
    }

    public void setClient(ClientsEntity client) {
        this.client = client;
    }

    public HotelsEntity getHotel() {
        return hotel;
    }

    public void setHotel(HotelsEntity hotel) {
        this.hotel = hotel;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public int getNumChambre() {
        return numChambre;
    }

    public void setNumChambre(int numChambre) {
        this.numChambre = numChambre;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ReservationsEntity)) return false;
        ReservationsEntity that = (ReservationsEntity) o;
        return getNumChambre() == that.getNumChambre() && getIdReservation().equals(that.getIdReservation()) && getClient().equals(that.getClient()) && getHotel().equals(that.getHotel()) && getDateDebut().equals(that.getDateDebut()) && getDateFin().equals(that.getDateFin());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdReservation(), getClient(), getHotel(), getDateDebut(), getDateFin(), getNumChambre());
    }
}
