package com.davr7.journey_jotter.dtos;

import java.util.List;

public record TripCreateDto(String city, String state, String startsAt, String endsAt, List<String> emailsToInvite, String ownerName, String ownerEmail) {
}
