package com.davr7.journey_jotter.services;

import com.davr7.journey_jotter.domain.User;
import com.davr7.journey_jotter.dtos.*;
import com.davr7.journey_jotter.repositories.UserRepository;
import com.davr7.journey_jotter.services.exceptions.UserAlreadyExistsException;
import com.davr7.journey_jotter.services.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    UserRepository userRepo;

    public DataUserDto createUser(CreateUserDto dto) {
        if (existsUserByEmail(dto.email())){
            throw new UserAlreadyExistsException();
        }

        User newUser = CreateUserDto.toUser(dto);
        return DataUserDto.convert(userRepo.save(newUser));
    }

    public UserDto findUserById(UUID id){
        Optional<User> user = userRepo.findById(id);
        user.orElseThrow(UserNotFoundException::new);
        return UserDto.convert(user.get());
    }

    public Boolean existsUserByEmail(String email) {
        return userRepo.existsByEmail(email);
    }
}
