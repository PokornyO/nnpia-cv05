package com.example.nnpiacv02.service;

import com.example.nnpiacv02.dto.InputAppUserDto;
import com.example.nnpiacv02.entity.AppUser;
import com.example.nnpiacv02.exceptions.AppUserException;
import com.example.nnpiacv02.repository.AppUserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.yaml")
@ActiveProfiles("test")
class AppUserServiceImplementationTestH2 {

    @Autowired
    private AppUserServiceImplementation appUserServiceImplementation;
    @Autowired
    private AppUserRepository appUserRepository;
    private AppUser user;

    @BeforeEach
    void setUp() {
      user = appUserServiceImplementation.createAppUse(new InputAppUserDto("testUser","xxx",false));
    }
    @AfterEach
    void tearDown() throws AppUserException {
        appUserRepository.deleteAll();
    }
    @Test
    void findUserById() throws AppUserException {
        AppUser newUser = appUserServiceImplementation.findUserById(user.getId());
        assertEquals(user.getUsername(), newUser.getUsername());
    }
}