package com.davr7.journey_jotter.dtos;

import com.davr7.journey_jotter.domain.Participant;
import com.davr7.journey_jotter.domain.Trip;

import java.util.UUID;

public record ParticipantDto(UUID id, String name, String email, Boolean isConfirmed, DataTripDto trip) {

    public static Participant toParticipant(ParticipantDto participant){
        return new Participant(participant.id(), participant.name(), participant.email(), participant.isConfirmed(), new Trip(participant.trip().id()));
    }
    public static ParticipantDto convert(Participant participant){
        return new ParticipantDto(participant.getId(), participant.getName(), participant.getEmail(), participant.getIsConfirmed(), new DataTripDto(participant.getTrip().getId()));
    }
}
