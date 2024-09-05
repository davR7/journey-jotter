package com.davr7.journey_jotter.dtos;

import com.davr7.journey_jotter.domain.Trip;

import java.util.UUID;

public record DataTripDto(UUID id) {
    public static DataTripDto convert(Trip trip){
        return new DataTripDto(trip.getId());
    }
}
