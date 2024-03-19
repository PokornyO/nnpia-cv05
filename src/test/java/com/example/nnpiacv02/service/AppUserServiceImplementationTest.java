package com.example.nnpiacv02.service;

import com.example.nnpiacv02.entity.AppUser;
import com.example.nnpiacv02.exceptions.AppUserException;
import com.example.nnpiacv02.repository.AppUserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
@SpringBootTest
class AppUserServiceImplementationTest {
    @Mock
    private AppUserRepository appUserRepositoryMock;
    @InjectMocks
    private AppUserServiceImplementation appUserService;
    @BeforeEach
    void setUp() {
        //appUserService = new AppUserServiceImplementation(appUserRepositoryMock);
    }

    @AfterEach
    void tearDown() {
    }

    //@Test(expected = SomeException.class)
    @Test
    void findUserById() throws AppUserException {
        AppUser user = new AppUser();
        user.setId(100L);
        user.setUsername("testUser");
        when(appUserRepositoryMock.findById(100L)).thenReturn(Optional.of(user));
        AppUser foundUser = appUserService.findUserById(100L);
        assertEquals(foundUser.getUsername(), user.getUsername());
    }
    @Test
    void findUserByIdException()  {
        assertThrows(AppUserException.class, () -> appUserService.findUserById(100L));
    }

}