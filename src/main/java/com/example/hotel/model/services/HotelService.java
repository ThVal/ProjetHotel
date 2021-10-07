package com.example.hotel.model.services;


import com.example.hotel.model.entities.HotelsEntity;
import com.example.hotel.model.repositories.HotelRepository;

import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class HotelService {

    private final HotelRepository hotelRepository;


    public HotelService(HotelRepository hotelRepository) {

        this.hotelRepository = hotelRepository;
    }

    public List<HotelsEntity> getAllHotels() {

        return (List<HotelsEntity>) hotelRepository.findAll();
    }

    public Optional<HotelsEntity> getHotelById(int id){

        return hotelRepository.findById(id);
    }

    private HotelsEntity setHotel (HotelsEntity hotel,
                                   String nom,
                                   String adresseHotel,
                                   int nbEtoile,
                                   String ville,
                                   String telephoneHotel,
                                   String emailHotel) {

        hotel.setNom(nom);
        hotel.setAdresseHotel(adresseHotel);
        hotel.setNbEtoile(nbEtoile);
        hotel.setVille(ville);
        hotel.setTelephoneHotel(telephoneHotel);
        hotel.setEmail(emailHotel);
        return hotel;
    }


    @Transactional
    public HotelsEntity addHotel(String nom,
                                 String adresseHotel,
                                 int nbEtoile,
                                 String ville,
                                 String telephoneHotel,
                                 String emailHotel) {

        HotelsEntity hotel = new HotelsEntity();
        return hotelRepository.save(setHotel(hotel,
                nom,
                adresseHotel,
                nbEtoile,
                ville,
                telephoneHotel,
                emailHotel));

    }

    @Transactional
    public HotelsEntity updateHotelById(int id,
                                        String nom,
                                        String adresseHotel,
                                        int nbEtoile,
                                        String ville,
                                        String telephoneHotel,
                                        String emailHotel) {

        Optional<HotelsEntity> hotelsOptional = getHotelById(id);
        if (hotelsOptional.isPresent()) {
            return hotelRepository.save(setHotel(hotelsOptional.get(),
                    nom,
                    adresseHotel,
                    nbEtoile,
                    ville,
                    telephoneHotel,
                    emailHotel));
        } else {

            throw new ObjectNotFoundException(id, "Hotel non trouvé");

        }

    }

    @Transactional
    public void deleteHotelById (int id){
        Optional<HotelsEntity> hotelOptional = getHotelById(id);

        if (hotelOptional.isPresent()){

            hotelRepository.delete(hotelOptional.get());}
        else {
            throw new ObjectNotFoundException(id, "Hotel non trouvé");
        }
    }



}
