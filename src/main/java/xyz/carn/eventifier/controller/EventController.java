package xyz.carn.eventifier.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.carn.eventifier.model.Event;
import xyz.carn.eventifier.model.Participant;
import xyz.carn.eventifier.service.EventService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/event")
public class EventController {
    private final EventService service;


    public EventController(EventService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Event> save(@RequestBody Event event) {
        return ResponseEntity.ok(service.save(event));
    }

    @GetMapping
    public ResponseEntity<List<Event>> getEvents() {
        return ResponseEntity.ok(service.getEvents());
    }

    @PatchMapping("/{id}/register")
    public ResponseEntity<Event> register(@PathVariable("id") long id, @RequestBody Participant participant) {
        return service.register(id, participant)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("/{id}/unregister")
    public ResponseEntity<Event> unregister(@PathVariable("id") long id, @RequestBody Participant participant) {
        return service.unregister(id, participant)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
