package com.example.hotel.model.repositories;

import com.example.hotel.model.entities.AdminsEntity;
import org.springframework.data.repository.CrudRepository;

public interface AdminRepository extends CrudRepository<AdminsEntity, Integer> {
}
