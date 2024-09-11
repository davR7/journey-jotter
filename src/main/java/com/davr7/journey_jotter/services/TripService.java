package com.davr7.journey_jotter.services;

import com.davr7.journey_jotter.domain.Trip;
import com.davr7.journey_jotter.domain.User;
import com.davr7.journey_jotter.dtos.CreateTripDto;
import com.davr7.journey_jotter.dtos.DataTripDto;
import com.davr7.journey_jotter.dtos.TripDto;
import com.davr7.journey_jotter.dtos.UserDto;
import com.davr7.journey_jotter.repositories.TripRepository;
import com.davr7.journey_jotter.services.exceptions.TripNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class TripService {
    @Autowired
    TripRepository tripRepo;

    @Autowired
    UserService userServ;

    public DataTripDto createTrip(CreateTripDto dto, UUID userId) {
        UserDto userDto = userServ.findUserById(userId);
        Trip newTrip = CreateTripDto.toTrip(dto, new User(userDto.id()));
        return DataTripDto.convert(tripRepo.save(newTrip));
    }

    public TripDto findTripById(UUID id){
        Optional<Trip> trip = tripRepo.findById(id);
        trip.orElseThrow(TripNotFoundException::new);
        return TripDto.convert(trip.get());
    }

    public TripDto confirmTrip(UUID userId, UUID tripId) {
        User user = UserDto.toUser(userServ.findUserById(userId));
        Trip rawTrip = TripDto.toTrip(findTripById(tripId), user);
        rawTrip.setIsConfirmed(true);
        Trip saved = tripRepo.save(rawTrip);
        return TripDto.convert(saved);
    }

    public Boolean checkIfTripExists(UUID id){
        return tripRepo.existsById(id);
    }
}
