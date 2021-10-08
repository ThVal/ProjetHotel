package com.example.hotel.api;

import com.example.hotel.model.entities.AdminsEntity;

import com.example.hotel.model.services.AdminService;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;



@RestController
@RequestMapping("api/admins")
//@Secured("ROLE_ADMIN")

public class AdminControllerApi {

    private AdminService adminService;

    public AdminControllerApi(AdminService adminService) {

        this.adminService = adminService;
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public AdminsEntity getAdminByIdApi(@PathVariable("id") int id) {
        Optional<AdminsEntity> adminOptional = adminService.getAdminById(id);
        if (adminOptional.isPresent()) {
            return adminOptional.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "admin found");

        }

    }

}
