package com.example.hotel.api;


import com.example.hotel.model.entities.HotelsEntity;
import com.example.hotel.model.services.HotelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/hotels")


public class HotelControllerApi {


    private HotelService hotelService;

    public HotelControllerApi(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping(path ="", produces = "application/json")
    public List<HotelsEntity> getHotelListApi () {
        return hotelService.getAllHotels(); }


    @GetMapping (path = "/{id}", produces = "application/json")
    public HotelsEntity getHotelByIdApi(@PathVariable("id") int id) {
            Optional<HotelsEntity> hotelOptional = hotelService.getHotelById(id);
            if (hotelOptional.isPresent()) {
                return hotelOptional.get();
            } else {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The hotel is not found");
            }
        }

    // String nom,
    // String adresseHotel,
    // int nbEtoile,
    // String ville,
    // String telephoneHotel,
    // String emailHotel)



    @PostMapping( path ="", produces = "application/json")
    public ResponseEntity<HotelsEntity> addHotelApi(@RequestBody HotelsEntity hotelInput) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                hotelService.addHotel(
                        hotelInput.getNom(),
                        hotelInput.getAdresseHotel(),
                        hotelInput.getNbEtoile(),
                        hotelInput.getVille(),
                        hotelInput.getTelephoneHotel(),
                        hotelInput.getEmailHotel()
                )
        );
    }


    @PutMapping(path = "/{id}", produces = "application/json")
    public ResponseEntity<HotelsEntity> editHotelApi(@PathVariable("id") int id, @RequestBody HotelsEntity hotelInput) {
        Optional<HotelsEntity> hotelOptional = hotelService.getHotelById(id);
        if (hotelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(
                    hotelService.updateHotelById(id,
                    hotelInput.getNom(),
                    hotelInput.getAdresseHotel(),
                    hotelInput.getNbEtoile(),
                    hotelInput.getVille(),
                    hotelInput.getTelephoneHotel(),
                    hotelInput.getEmailHotel()
            ));
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The hotel is not found");
        }
    }

    @DeleteMapping(path = "/{id}", produces = "application/json")
    public ResponseEntity<String> deleteHotelApi(@PathVariable("id") int id) {
        Optional<HotelsEntity> hotelOptional = hotelService.getHotelById(id);
        if (hotelOptional.isPresent()) {
            hotelService.deleteHotelById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Hotel" + id + "effacé");


        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The hotel is not found");
        }
    }

}
