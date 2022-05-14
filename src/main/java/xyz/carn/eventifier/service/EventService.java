package xyz.carn.eventifier.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import xyz.carn.eventifier.model.Event;
import xyz.carn.eventifier.model.Participant;
import xyz.carn.eventifier.repository.EventRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.DoubleStream;

@Service
public class EventService {
    private final EventRepository repository;

    public EventService(EventRepository repository) {
        this.repository = repository;
    }

    public Event save(Event event) {
        return repository.save(event);
    }

    public List<Event> getEvents() {
        return repository.findAll();
    }

    public Optional<Event> register(long id, Participant participant) {
        Optional<Event> eventOptional = repository.findById(id);
        if (eventOptional.isPresent()) {
            Event event = eventOptional.get();
            Set<Participant> participants = event.getParticipants();
            participants.add(participant);
            event.setParticipants(participants);
            return Optional.of(repository.save(event));
        } else {
            return Optional.empty();
        }
    }

    public Optional<Event> unregister(long id, Participant participant) {
        Optional<Event> eventOptional = repository.findById(id);
        if (eventOptional.isPresent()) {
            Event event = eventOptional.get();
            Set<Participant> participants = event.getParticipants();
            participants.remove(participant);
            event.setParticipants(participants);
            return Optional.of(repository.save(event));
        } else {
            return Optional.empty();
        }
    }
}
