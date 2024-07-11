package com.davr7.journey_jotter.services;

import com.davr7.journey_jotter.domain.Participant;
import com.davr7.journey_jotter.domain.Trip;
import com.davr7.journey_jotter.repositories.ParticipantRepository;
import com.davr7.journey_jotter.services.exceptions.ParticipantNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ParticipantService {
    @Autowired
    ParticipantRepository participantRepo;

    public Participant confirmParticipant(UUID id) {
        Optional<Participant> participant = participantRepo.findById(id);

        if (participant.isEmpty()) {
            throw new ParticipantNotFoundException();
        }

        Participant rawParticipant = participant.get();
        rawParticipant.setIsConfirmed(true);
        return participantRepo.save(rawParticipant);
    }

    public void registerParticipantsToEvent(List<String> emailList, Trip trip) {
        List<Participant> participants = emailList.stream().map(email -> new Participant(email, trip)).toList();
        participantRepo.saveAll(participants);
    }
}
