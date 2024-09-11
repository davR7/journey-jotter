package com.davr7.journey_jotter.dtos;

import com.davr7.journey_jotter.domain.User;

public record CreateUserDto(String name, String email) {
    public static User toUser(CreateUserDto dto){
        return new User(null, dto.name(), dto.email());
    }
}
