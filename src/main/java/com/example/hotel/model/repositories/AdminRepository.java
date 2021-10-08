package com.example.hotel.model.repositories;

import com.example.hotel.model.entities.AdminsEntity;
import org.springframework.data.repository.CrudRepository;

public interface AdminRepository extends CrudRepository<AdminsEntity, Integer> {


    public AdminsEntity findByUsername(String username);


    /* SELECT * FROM user WHERE email = :email OR username = :username */


}
