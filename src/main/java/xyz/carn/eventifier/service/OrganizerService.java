package xyz.carn.eventifier.service;

import org.springframework.stereotype.Service;
import xyz.carn.eventifier.model.Organizer;
import xyz.carn.eventifier.repository.OrganizerRepository;

@Service
public class OrganizerService {
    private final OrganizerRepository repository;

    public OrganizerService(OrganizerRepository repository) {
        this.repository = repository;
    }

    public Organizer register(Organizer organizer) {
        return repository.save(organizer);
    }
}
