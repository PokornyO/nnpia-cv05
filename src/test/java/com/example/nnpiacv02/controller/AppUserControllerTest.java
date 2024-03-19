package com.example.nnpiacv02.controller;


import com.example.nnpiacv02.dto.InputAppUserDto;
import com.example.nnpiacv02.entity.AppUser;
import com.example.nnpiacv02.exceptions.AppUserException;
import com.example.nnpiacv02.service.AppUserServiceImplementation;
import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;


import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-test.yaml")
@ActiveProfiles("test")
class AppUserControllerTest {
    @LocalServerPort
    int port;
    @Autowired
    AppUserServiceImplementation appUserServiceImplementation;
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }
    @Test
    public void testGetUserById_existingUser_returns200() throws IOException, AppUserException {
        AppUser appUser = appUserServiceImplementation.createAppUse(new InputAppUserDto("testUser", "llll",true));
        HttpClient client = HttpClientBuilder.create().build();
        Long userId = appUser.getId();
        HttpGet request = new HttpGet("http://127.0.0.1:"+port+"/api/v1/app-user/" + userId);
        HttpResponse response = client.execute(request);
        appUserServiceImplementation.deleteAppUser(appUser.getId());
        assertEquals(200, response.getCode());
    }
    @Test
    public void testGetUserById_existingUser_returns400() throws IOException, AppUserException {
        AppUser appUser = appUserServiceImplementation.createAppUse(new InputAppUserDto("testUser", "xdd",true));
        HttpClient client = HttpClientBuilder.create().build();
        Long userId = appUser.getId();
        appUserServiceImplementation.deleteAppUser(appUser.getId());
        String url = "http://localhost:"+port+"/api/v1/app-user/" + userId;
        HttpGet request = new HttpGet(url);
        HttpResponse response = client.execute(request);
        assertEquals(404, response.getCode());
    }


}