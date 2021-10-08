package com.example.hotel.api;

import com.example.hotel.model.entities.AdminsEntity;
import com.example.hotel.model.repositories.AdminRepository;
import com.example.hotel.model.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


@RestController
@RequestMapping("/login")
public class LoginControllerApi {

    @Autowired
    private AdminRepository adminRepository;


    @PostMapping(path = "", produces = "application/json")
    ResponseEntity<AdminsEntity> checkLogin(@RequestBody AdminsEntity userv ){
        System.out.println( userv.getUsername() );
        System.out.println(userv);
        System.out.println("CHOCOLATINE");

        try{
            AdminsEntity user = adminRepository.findByUsername(userv.getUsername());
            return ResponseEntity.ok() // ok => 200
                    .body(user);

        }catch ( Exception e ){
            System.out.println("Je suis ici");
            throw new ResponseStatusException( HttpStatus.BAD_REQUEST , e.getMessage() ); // KO : 400
        }

    }


}

