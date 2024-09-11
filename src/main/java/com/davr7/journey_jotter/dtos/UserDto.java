package com.davr7.journey_jotter.dtos;

import com.davr7.journey_jotter.domain.User;

import java.util.UUID;

public record UserDto(UUID id, String name, String email) {
    public static UserDto convert(User user){
        return new UserDto(user.getId(), user.getName(), user.getEmail());
    }

    public static  User toUser(UserDto userDtp){
        return new User(userDtp.id(), userDtp.name(), userDtp.email());
    }
}
