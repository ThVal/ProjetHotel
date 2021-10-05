package com.example.hotel.model.repositories;

import com.example.hotel.model.entities.ReservationsEntity;
import org.springframework.data.repository.CrudRepository;

public interface ReservationRepository extends CrudRepository<ReservationsEntity, Integer> {
}
