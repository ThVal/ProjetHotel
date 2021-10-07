package com.example.hotel.model.services;

import com.example.hotel.model.entities.ClientsEntity;
import com.example.hotel.model.entities.ReservationsEntity;
import com.example.hotel.model.repositories.ReservationRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
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
                                              int clientId,
                                              int hotelId,
                                              Date datedeb,
                                              Date datefin,
                                              int numChambre) {


        reservation.setClient(clientService.getClientById(clientId).get());
        reservation.setHotel(hotelService.getHotelById(hotelId).get());
        reservation.setDateDebut(datedeb);
        reservation.setDateFin(datefin);
        reservation.setNumChambre(numChambre);

        return reservationRepository.save(reservation);

    }


    @Transactional
    // CREATE
    public ReservationsEntity addReservation(int clientId,
                                             int hotelId,
                                             Date datedeb,
                                             Date datefin,
                                             int numChambre) {
        ReservationsEntity reservation = new ReservationsEntity();
        return reservationRepository.save(setReservation(
                reservation,
                clientId,
                hotelId,
                datedeb,
                datefin,
                numChambre));

    }


    @Transactional
    public ReservationsEntity updateReservationById(int id,
                                                    int client,
                                                    int hotel,
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
