package com.example.hotel.model.services;

import com.example.hotel.model.entities.AdminsEntity;
import com.example.hotel.model.repositories.AdminRepository;

import java.util.List;
import java.util.Optional;

public class AdminService {

    private final AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }


    public Optional<AdminsEntity> getAdminById(int id) {

        return adminRepository.findById(id);
    }

}



