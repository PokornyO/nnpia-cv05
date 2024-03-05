package com.example.nnpiacv02.service;

import com.example.nnpiacv02.dto.AppUserDto;
import com.example.nnpiacv02.dto.InputAppUserDto;
import com.example.nnpiacv02.entity.AppUser;
import com.example.nnpiacv02.exceptions.AppUserException;

import java.util.List;
import java.util.Optional;

public interface AppUserService {
    List<AppUser> getActiveUsers(Boolean active);
    List<AppUser> findUsersByRole(String role);
    AppUser findUserById(Long id) throws AppUserException;
    AppUser createAppUse(InputAppUserDto inputUser);
    AppUser updateAppUser(InputAppUserDto appUser, Long id) throws AppUserException;
    void deleteAppUser(Long id) throws AppUserException;
}
