package com.davr7.journey_jotter.services.exceptions;

public class ParticipantNotFoundException extends RuntimeException {
    public ParticipantNotFoundException(){
        super("Participant not found");
    }
}
