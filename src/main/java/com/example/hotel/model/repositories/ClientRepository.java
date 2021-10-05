package com.example.hotel.model.repositories;

import com.example.hotel.model.entities.ClientsEntity;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<ClientsEntity, Integer> {
}
