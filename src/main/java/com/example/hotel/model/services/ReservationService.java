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

        return reservationRepository.save(reservation);

    }


    @Transactional
    // CREATE
    public ReservationsEntity addReservation(ClientsEntity client,
                                             HotelsEntity hotel,
                                             Date datedeb,
                                             Date datefin,
                                             int numChambre) {
        ReservationsEntity reservation = new ReservationsEntity();
        return reservationRepository.save(setReservation(reservation,client, hotel, datedeb, datefin, numChambre));

    }


    @Transactional
    public ReservationsEntity updateReservationById(int id,
                                                    ClientsEntity client,
                                                    HotelsEntity hotel,
                                                    Date datedeb,
                                                    Date datefin,
                                                    int numChambre) {
        Optional<ReservationsEntity> reservationOptional = getReservationById(id);
        if (reservationOptional.isPresent()) {
            return reservationRepository.save(setReservation(reservationOptional.get(), client, hotel, datedeb,datefin,numChambre));
        } else {
            throw new ObjectNotFoundException(id, "pas de réservation");


        }
    }

    @Transactional
    public void deleteReservationById(int id) {
        Optional<ReservationsEntity> reservationOptional = getReservationById(id);

        if (reservationOptional.isPresent()) {
            reservationRepository.delete(reservationOptional.get());
        } else {
            throw new ObjectNotFoundException(id, "city unknown");

        }
    }




}
