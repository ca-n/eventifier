package xyz.carn.eventifier.service;

import xyz.carn.eventifier.model.Participant;
import xyz.carn.eventifier.repository.ParticipantRepository;

public class ParticipantService {
    private final ParticipantRepository repository;

    public ParticipantService(ParticipantRepository repository) {
        this.repository = repository;
    }

    public Participant register(Participant participant) {
        return repository.save(participant);
    }
}
