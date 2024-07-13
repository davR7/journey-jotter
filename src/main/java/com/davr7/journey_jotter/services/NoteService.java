package com.davr7.journey_jotter.services;

import com.davr7.journey_jotter.domain.Note;
import com.davr7.journey_jotter.domain.Trip;
import com.davr7.journey_jotter.dtos.NoteCreateDto;
import com.davr7.journey_jotter.dtos.NoteResponseDto;
import com.davr7.journey_jotter.repositories.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class NoteService {
    @Autowired
    NoteRepository noteRepo;

    @Autowired
    TripService tripServ;

    public Note createNoteToTrip(UUID tripId, NoteCreateDto data){
        Trip trip = tripServ.findTripById(tripId);
        Note note = new Note(data, trip);
        return noteRepo.save(note);
    }

    public List<NoteResponseDto> findNotesFromTrip(UUID tripId){
        return noteRepo.findByTripId(tripId).stream().map(n ->
                new NoteResponseDto(n.getId(), n.getTitle(), n.getDescription(), n.getUrl())).toList();
    }
}
