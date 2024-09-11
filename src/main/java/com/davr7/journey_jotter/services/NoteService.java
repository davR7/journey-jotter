package com.davr7.journey_jotter.services;

import com.davr7.journey_jotter.domain.Note;
import com.davr7.journey_jotter.domain.Trip;
import com.davr7.journey_jotter.dtos.CreateNoteDto;
import com.davr7.journey_jotter.dtos.DataNoteDto;
import com.davr7.journey_jotter.dtos.NoteDto;
import com.davr7.journey_jotter.dtos.TripDto;
import com.davr7.journey_jotter.repositories.NoteRepository;
import com.davr7.journey_jotter.services.exceptions.TripNotFoundException;
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

    public DataNoteDto createNoteToTrip(CreateNoteDto dto, UUID tripId){
        TripDto tripDto = tripServ.findTripById(tripId);
        Note note = CreateNoteDto.toNote(dto, tripDto);
        return DataNoteDto.convert(noteRepo.save(note));
    }

    public List<NoteDto> findNotesFromTrip(UUID tripId){
        if (!tripServ.checkIfTripExists(tripId)){
            throw new TripNotFoundException();
        }

        return noteRepo.findByTripId(tripId).stream().map(n ->
                new NoteDto(n.getId(), n.getTitle(), n.getDescription(), n.getUrl())).toList();
    }
}
