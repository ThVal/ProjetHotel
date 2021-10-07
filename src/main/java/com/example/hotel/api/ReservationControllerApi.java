package com.example.hotel.api;

import com.example.hotel.model.entities.ClientsEntity;
import com.example.hotel.model.entities.HotelsEntity;
import com.example.hotel.model.entities.ReservationsEntity;
import com.example.hotel.model.services.HotelService;
import com.example.hotel.model.services.ReservationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/reservations")

public class ReservationControllerApi {

    private ReservationService reservationService;

    public ReservationControllerApi(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping(path ="", produces = "application/json")
    public List<ReservationsEntity> getReservationListApi () {
            return reservationService.getAllReservations(); }


    @GetMapping (path = "/{id}", produces = "application/json")
    public ReservationsEntity getReservationByIdApi(@PathVariable("id") int id) {
        Optional<ReservationsEntity> reservationOptional = reservationService.getReservationById(id);
        if (reservationOptional.isPresent()) {
            return reservationOptional.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The hotel is not found");
        }
    }

    @PostMapping(path="", produces = "application/json")
    public ResponseEntity<ReservationsEntity> addReservationApi(@RequestBody ReservationsEntity reservationInput) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                reservationService.addReservation(
                        reservationInput.getClient().getIdClient(),
                        reservationInput.getHotel().getIdHotel(),
                        reservationInput.getDateDebut(),
                        reservationInput.getDateFin(),
                        reservationInput.getNumChambre()));
    }
    /*ReservationsEntity reservation,
    ClientsEntity client,
    HotelsEntity hotel,
    Date datedeb,
    Date datefin,
    int numChambre) {*/

    @PutMapping(path = "/{id}", produces = "application/json")
    public ResponseEntity<ReservationsEntity> editReservationApi(@PathVariable("id") int id, @RequestBody ReservationsEntity reservationInput) {
        Optional<ReservationsEntity> reservationOptional = reservationService.getReservationById(id);
        if (reservationOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(
                    reservationService.updateReservationById(id,
                            reservationInput.getClient().getIdClient(),
                            reservationInput.getHotel().getIdHotel(),
                            reservationInput.getDateDebut(),
                            reservationInput.getDateFin(),
                            reservationInput.getNumChambre()));

        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "reserve is not found");
        }
    }

    @DeleteMapping(path = "/{id}", produces = "application/json")
    public ResponseEntity<String> deleteReservationApi(@PathVariable("id") int id) {
        Optional<ReservationsEntity> ReservationOptional = reservationService.getReservationById(id);
        if (ReservationOptional.isPresent()) {
            reservationService.deleteReservationById(id);
            return ResponseEntity.status(HttpStatus.OK).body("reserve" + id + "effacée");


        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The hotel is not found");
        }
    }




    }
