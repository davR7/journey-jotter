package com.davr7.journey_jotter.repositories;

import com.davr7.journey_jotter.domain.Note;
import com.davr7.journey_jotter.domain.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface NoteRepository extends JpaRepository<Note, UUID> {
    List<Note> findByTripId(UUID tripId);
}
