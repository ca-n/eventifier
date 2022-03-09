package xyz.carn.eventifier.service;

import org.springframework.stereotype.Service;
import xyz.carn.eventifier.model.Participant;
import xyz.carn.eventifier.repository.ParticipantRepository;

@Service
public class ParticipantService {
    private final ParticipantRepository repository;

    public ParticipantService(ParticipantRepository repository) {
        this.repository = repository;
    }

    public Participant register(Participant participant) {
        return repository.save(participant);
    }
}
