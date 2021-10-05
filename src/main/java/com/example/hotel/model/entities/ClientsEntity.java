package com.example.hotel.model.entities;


import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table (name = "clients")
public class ClientsEntity implements Serializable {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idClient;

    @Basic
    private String nomCompletClient;

    @Basic
    private String telephoneClient;

    @Basic
    private String emailClient;

    @Basic
    private String adresseClient;

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public String getNomCompletClient() {
        return nomCompletClient;
    }

    public void setNomCompletClient(String nomCompletClient) {
        this.nomCompletClient = nomCompletClient;
    }

    public String getTelephoneClient() {
        return telephoneClient;
    }

    public void setTelephoneClient(String telephoneClient) {
        this.telephoneClient = telephoneClient;
    }

    public String getEmailClient() {
        return emailClient;
    }

    public void setEmailClient(String emailClient) {
        this.emailClient = emailClient;
    }

    public String getAdresseClient() {
        return adresseClient;
    }

    public void setAdresseClient(String adresseClient) {
        this.adresseClient = adresseClient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClientsEntity)) return false;
        ClientsEntity clientsEntity = (ClientsEntity) o;
        return Objects.equals(getIdClient(), clientsEntity.getIdClient()) && Objects.equals(getNomCompletClient(), clientsEntity.getNomCompletClient()) && Objects.equals(getTelephoneClient(), clientsEntity.getTelephoneClient()) && Objects.equals(getEmailClient(), clientsEntity.getEmailClient()) && Objects.equals(getAdresseClient(), clientsEntity.getAdresseClient());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdClient(), getNomCompletClient(), getTelephoneClient(), getEmailClient(), getAdresseClient());
    }
}
