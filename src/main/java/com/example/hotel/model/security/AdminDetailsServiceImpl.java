package com.example.hotel.model.security;


import com.example.hotel.model.entities.AdminsEntity;
import com.example.hotel.model.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AdminDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public AdminDetailsImpl loadUserByUsername(String usernameField ) throws
            UsernameNotFoundException {
        AdminsEntity admin = adminRepository.findByUsername(usernameField);
        System.out.println(usernameField);
        System.out.println(admin);
        if(admin == null) {
            throw new UsernameNotFoundException("No user named " + usernameField);
        } else {
            return new AdminDetailsImpl(admin);
        }
    }


}


