package com.example.nnpiacv02.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
@Data
@AllArgsConstructor
public class InputAppUserDto {
    @NotNull
    @NotEmpty
    @Size(max = 255)
    private String username;
    private String password;
    private boolean active;
}
