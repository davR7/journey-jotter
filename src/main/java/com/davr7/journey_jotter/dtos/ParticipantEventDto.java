package com.davr7.journey_jotter.dtos;

import java.util.UUID;

public record ParticipantEventDto(UUID id, String name, String email, Boolean isConfirmed) {
}
