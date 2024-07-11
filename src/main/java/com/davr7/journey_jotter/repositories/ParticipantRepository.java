package com.davr7.journey_jotter.repositories;

import com.davr7.journey_jotter.domain.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ParticipantRepository extends JpaRepository<Participant, UUID> {
}
