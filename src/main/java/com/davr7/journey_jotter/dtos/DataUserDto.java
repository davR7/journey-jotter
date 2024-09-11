package com.davr7.journey_jotter.dtos;

import com.davr7.journey_jotter.domain.User;

import java.util.UUID;

public record DataUserDto(UUID id) {
    public static DataUserDto convert(User user){
        return new DataUserDto(user.getId());
    }
}
