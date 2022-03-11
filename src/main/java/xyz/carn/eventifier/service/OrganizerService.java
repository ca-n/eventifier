package xyz.carn.eventifier.service;

import org.springframework.stereotype.Service;
import xyz.carn.eventifier.model.Organizer;
import xyz.carn.eventifier.model.User;
import xyz.carn.eventifier.repository.OrganizerRepository;

import java.util.Optional;

@Service
public class OrganizerService {
    private final OrganizerRepository repository;

    public OrganizerService(OrganizerRepository repository) {
        this.repository = repository;
    }

    public Organizer register(Organizer organizer) {
        return repository.save(organizer);
    }

    public Optional<Organizer> login(User credentials) {
        return repository.findByEmailAndPassword(credentials.getEmail(), credentials.getPassword());
    }
}
