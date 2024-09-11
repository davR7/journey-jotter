package com.davr7.journey_jotter.services;

import com.davr7.journey_jotter.domain.Participant;
import com.davr7.journey_jotter.domain.Trip;
import com.davr7.journey_jotter.dtos.DataTripDto;
import com.davr7.journey_jotter.dtos.ConfirmParticipantDto;
import com.davr7.journey_jotter.dtos.ParticipantDto;
import com.davr7.journey_jotter.repositories.ParticipantRepository;
import com.davr7.journey_jotter.services.exceptions.ParticipantNotFoundException;
import com.davr7.journey_jotter.services.exceptions.TripNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ParticipantService {
    @Autowired
    ParticipantRepository participantRepo;

    @Autowired
    TripService tripServ;

    public ParticipantDto findParticipantById(UUID id) {
        Optional<Participant> participant = participantRepo.findById(id);
        participant.orElseThrow(ParticipantNotFoundException::new);
        return ParticipantDto.convert(participant.get());
    }

    public ParticipantDto confirmParticipant(UUID id, ConfirmParticipantDto data) {
        Participant rawParticipant = ParticipantDto.toParticipant(findParticipantById(id));
        rawParticipant.setName(data.name());
        rawParticipant.setIsConfirmed(true);
        return ParticipantDto.convert(participantRepo.save(rawParticipant));
    }

    public void registerParticipantsToTrip(List<String> emailList, DataTripDto tripDto) {
        List<Participant> participants = emailList.stream().map(email -> new Participant(email, new Trip(tripDto.id()))).toList();
        participantRepo.saveAll(participants);
    }

    public List<ParticipantDto> findAllParticipantsFromTrip(UUID tripId){
        if (!tripServ.checkIfTripExists(tripId)){
            throw new TripNotFoundException();
        }

        return participantRepo.findByTripId(tripId).stream().map(p ->
                new ParticipantDto(p.getId(), p.getName(), p.getEmail(), p.getIsConfirmed(), new DataTripDto(p.getTrip().getId()))).toList();
    }
}
