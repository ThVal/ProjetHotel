package com.example.hotel.model.services;

import com.example.hotel.model.entities.ClientsEntity;
import com.example.hotel.model.entities.HotelsEntity;
import com.example.hotel.model.entities.ReservationsEntity;
import com.example.hotel.model.repositories.ReservationRepository;
import org.hibernate.ObjectNotFoundException;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class ReservationService {


    private final ReservationRepository reservationRepository ;

    private final HotelService hotelService;

    private final ClientService clientService;




    public ReservationService(ReservationRepository reservationRepository, HotelService hotelService, ClientService clientService) {
        this.reservationRepository = reservationRepository;
        this.hotelService = hotelService;
        this.clientService = clientService;
    }

    public List<ReservationsEntity> getAllReservations() {

        return (List<ReservationsEntity>) reservationRepository.findAll();
    }

    public Optional<ReservationsEntity> getReservationById(int id) {
        return reservationRepository.findById(id);  // optional gere une éventualité
    }


    private ReservationsEntity setReservation(ReservationsEntity reservation,
                                              ClientsEntity client,
                                              HotelsEntity hotel,
                                              Date datedeb,
                                              Date datefin,
                                              int numChambre) {


        reservation.setClient(client);
        reservation.setHotel(hotel);
        reservation.setDateDebut(datedeb);
        reservation.setDateFin(datefin);
        reservation.setNumChambre(numChambre);

        reservationRepository.save(reservation);

    }


    @Transactional
    // CREATE
    public CitiesEntity addCity(String name, String zipCode) {
        CitiesEntity city = new CitiesEntity();
        return cityRepository.save(setCity(city, name, zipCode));

    }


    @Transactional
    public CitiesEntity updateCityById(int id, String name, String zipCode) {
        Optional<CitiesEntity> cityOptional = getCityById(id);
        if (cityOptional.isPresent()) {
            return cityRepository.save(setCity(cityOptional.get(), name, zipCode));
        } else {
            throw new ObjectNotFoundException(id, "City not found");


        }
    }

    @Transactional
    public void deleteCityById(int id) {
        Optional<CitiesEntity> cityOptional = getCityById(id);

        if (cityOptional.isPresent()) {
            cityRepository.delete(cityOptional.get());
        } else {
            throw new ObjectNotFoundException(id, "city unknown");

        }
    }




}
