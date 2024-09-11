package com.davr7.journey_jotter.dtos;

import com.davr7.journey_jotter.common.DateUtils;
import com.davr7.journey_jotter.domain.Trip;
import com.davr7.journey_jotter.domain.User;

import java.util.List;
import java.util.UUID;

public record CreateTripDto(String city, String state, String startsAt, String endsAt, List<String> emailsToInvite, UUID ownerId) {
    public static Trip toTrip(CreateTripDto dto, User owner){
        return new Trip(null, dto.city, dto.state, DateUtils.parseIsoDateTime(dto.startsAt), DateUtils.parseIsoDateTime(dto.endsAt), false, owner);
    }
}
