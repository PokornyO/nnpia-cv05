package com.example.nnpiacv02.service;

import com.example.nnpiacv02.dto.InputAppUserDto;
import com.example.nnpiacv02.entity.AppUser;
import com.example.nnpiacv02.exceptions.AppUserException;
import com.example.nnpiacv02.repository.AppUserRepository;
import com.fasterxml.jackson.annotation.OptBoolean;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AppUserServiceImplementation implements AppUserService {
    private final AppUserRepository repository;

    public AppUserServiceImplementation(AppUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<AppUser> getActiveUsers(Boolean active) {
        return repository.findAppUserByActive(active);
    }

    @Override
    public List<AppUser> findUsersByRole(String role) {
       return repository.findAppUsersByRoleName(role);
    }

    @Override
    public AppUser findUserById(Long id) throws AppUserException {
        Optional<AppUser> appUser = repository.findById(id);
        if(appUser.isEmpty()) {
            throw new AppUserException("User with id: " + id + " not found");
        }
        return appUser.get();
    }

    @Override
    public AppUser createAppUse(InputAppUserDto inputUser) {
       AppUser user = new AppUser(inputUser.getUsername(), inputUser.getPassword(), inputUser.isActive(), new Date(), new Date());
       return repository.save(user);
    }

    @Override
    public AppUser updateAppUser(InputAppUserDto appUser, Long id) throws AppUserException {
        AppUser user = findUserById(id);
        user.setActive(appUser.isActive());
        user.setUsername(appUser.getUsername());
        user.setPassword(appUser.getPassword());
        user.setUpdate_date(new Date());
        return repository.save(user);
    }

    @Override
    public void deleteAppUser(Long id) throws AppUserException {
        repository.delete(findUserById(id));
    }
}
