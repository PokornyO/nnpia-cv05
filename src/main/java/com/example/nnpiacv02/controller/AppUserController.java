package com.example.nnpiacv02.controller;

import com.example.nnpiacv02.dto.AppUserDto;
import com.example.nnpiacv02.dto.InputAppUserDto;
import com.example.nnpiacv02.entity.AppUser;
import com.example.nnpiacv02.exceptions.AppUserException;
import com.example.nnpiacv02.mapper.AppUserMapper;
import com.example.nnpiacv02.repository.AppUserRepository;
import com.example.nnpiacv02.service.AppUserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AppUserController {
    private final AppUserService service;

    public AppUserController(AppUserService service) {
        this.service = service;
    }

    @GetMapping("/app-user/active")
    public List<AppUser> getActiveUsers() {
        List<AppUser> users = service.getActiveUsers(true);
        return service.getActiveUsers(true);
    }
    @GetMapping("/app-user/role/{role}")
    public List<AppUser> getProductById(@PathVariable String role) {
        return service.findUsersByRole(role);
    }
    @GetMapping("/app-user/{id}")
    public ResponseEntity<AppUserDto> getUserById(@PathVariable Long id) throws AppUserException {
        return ResponseEntity.ok(AppUserMapper.mapAppUserToAppUserDto(service.findUserById(id)));
    }
    @PostMapping("app-user")
    public ResponseEntity<AppUserDto> createUser(@Valid @RequestBody InputAppUserDto inputUser) {
        return new ResponseEntity<>(AppUserMapper.mapAppUserToAppUserDto(service.createAppUse(inputUser)), HttpStatus.CREATED);
    }
    @PutMapping("app-user/{id}")
    public ResponseEntity<AppUserDto> updateUser(@Valid @RequestBody InputAppUserDto inputUser, @PathVariable Long id) throws AppUserException {
        return new ResponseEntity<>(AppUserMapper.mapAppUserToAppUserDto(service.updateAppUser(inputUser, id)), HttpStatus.OK);
    }
    @DeleteMapping("app-user/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) throws AppUserException {
        service.deleteAppUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
