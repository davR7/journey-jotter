package com.davr7.journey_jotter.services.exceptions;

public class TripNotFoundException extends RuntimeException {
    public TripNotFoundException(){
        super("Trip not found");
    }
}
