package com.example.hotel.model.security;

import com.example.hotel.model.entities.AdminsEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class AdminDetailsImpl implements UserDetails {
    private AdminsEntity admin;
    public AdminDetailsImpl(AdminsEntity admin){
        this.admin = admin;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        final List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority(admin.getRole()));
        return authorities;
    }

    public AdminsEntity getAdmin() {

        return admin;
    }

    @Override
    public String getPassword() {
        System.out.println(admin.getPassword());
        return admin.getPassword();
    }

    @Override
    public String getUsername() {

        return admin.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
