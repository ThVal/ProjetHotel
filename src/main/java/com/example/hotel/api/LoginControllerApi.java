//package com.example.hotel.api;

import com.example.hotel.model.entities.AdminsEntity;
import com.example.hotel.model.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

/*
@RestController
@RequestMapping("/api/login")
public class LoginAPIController {

    @Autowired
    AdminRepository adminRepository;


    @PostMapping(path = "", produces = "application/json")
    ResponseEntity<AdminsEntity> checkLogin(@RequestBody AdminsEntity userv ){
        System.out.println( userv.getUsername() );

        try{
            AdminsEntity user = AdminRepository.getIdAdmin(userv.getIdAdmin());
            return ResponseEntity.ok() // ok => 200
                    .body(user);

        }catch ( Exception e ){
            System.out.println("Je suis ici");
            throw new ResponseStatusException( HttpStatus.BAD_REQUEST , e.getMessage() ); // KO : 400
        }

    }


}
*/
