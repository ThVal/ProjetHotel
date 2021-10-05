package com.example.hotel.model.repositories;

import com.example.hotel.model.entities.HotelsEntity;
import org.springframework.data.repository.CrudRepository;

public interface HotelRepository extends CrudRepository<HotelsEntity, Integer> {
}
