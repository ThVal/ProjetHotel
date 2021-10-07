package com.example.hotel.model.services;

import com.example.hotel.model.entities.AdminsEntity;
import com.example.hotel.model.repositories.AdminRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AdminService {

    private final AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }


    public Optional<AdminsEntity> getAdminById(int id) {

        return adminRepository.findById(id);
    }

}



