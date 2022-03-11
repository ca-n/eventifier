package xyz.carn.eventifier.service;

import org.springframework.stereotype.Service;
import xyz.carn.eventifier.model.Participant;
import xyz.carn.eventifier.model.User;
import xyz.carn.eventifier.repository.ParticipantRepository;

import java.util.Optional;

@Service
public class ParticipantService {
    private final ParticipantRepository repository;

    public ParticipantService(ParticipantRepository repository) {
        this.repository = repository;
    }

    public Participant register(Participant participant) {
        return repository.save(participant);
    }

    public Optional<Participant> login(User credentials) {
        return repository.findByEmailAndPassword(credentials.getEmail(), credentials.getPassword());
    }
}
