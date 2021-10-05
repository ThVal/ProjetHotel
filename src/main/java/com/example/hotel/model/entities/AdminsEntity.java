package com.example.hotel.model.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;


@Entity
@Table(name="admins")

public class AdminsEntity implements Serializable {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY) //autoincrement
    private Integer idAdmin;

    @Basic
    private String username;

    @Basic
    private String password;

    @Basic String role;


    public Integer getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(Integer idAdmin) {
        this.idAdmin = idAdmin;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AdminsEntity)) return false;
        AdminsEntity that = (AdminsEntity) o;
        return getIdAdmin().equals(that.getIdAdmin()) && getUsername().equals(that.getUsername()) && getPassword().equals(that.getPassword()) && getRole().equals(that.getRole());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdAdmin(), getUsername(), getPassword(), getRole());
    }
}
