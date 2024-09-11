package com.davr7.journey_jotter.dtos;

import com.davr7.journey_jotter.domain.Trip;
import com.davr7.journey_jotter.domain.User;

import java.time.LocalDateTime;
import java.util.UUID;

public record TripDto(UUID id, String city, String state, LocalDateTime startsAt, LocalDateTime endsAt, Boolean isConfirmed, DataUserDto user) {
    public static Trip toTrip(TripDto tripDto, User user){
        return new Trip(tripDto.id(), tripDto.city(), tripDto.state(), tripDto.startsAt(), tripDto.endsAt(), tripDto.isConfirmed(), user);
    }

    public static TripDto convert(Trip trip){
        return new TripDto(trip.getId(), trip.getCity(), trip.getState(), trip.getStartsAt(), trip.getEndsAt(), trip.getIsConfirmed(), new DataUserDto(trip.getUser().getId()));
    }
}
