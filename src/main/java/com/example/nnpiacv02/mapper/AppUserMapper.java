package com.example.nnpiacv02.mapper;

import com.example.nnpiacv02.dto.AppUserDto;
import com.example.nnpiacv02.entity.AppUser;

public class AppUserMapper {
    public static AppUserDto mapAppUserToAppUserDto(AppUser user) {
        return new AppUserDto(user.getId(), user.getUsername(), user.getPassword(), user.isActive(), user.getCreation_date(), user.getUpdate_date());
    }

}
