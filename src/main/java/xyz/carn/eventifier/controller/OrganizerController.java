package xyz.carn.eventifier.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.carn.eventifier.model.Organizer;
import xyz.carn.eventifier.model.User;
import xyz.carn.eventifier.service.OrganizerService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/organizer")
public class OrganizerController {
    private final OrganizerService service;

    public OrganizerController(OrganizerService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Organizer> register(@RequestBody Organizer organizer) {
        return ResponseEntity.ok(service.register(organizer));
    }

    @PostMapping("/login")
    public ResponseEntity<Organizer> login(@RequestBody User credentials) {
        return service.login(credentials)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }
}
