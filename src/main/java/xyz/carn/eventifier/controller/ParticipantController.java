package xyz.carn.eventifier.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.carn.eventifier.model.Participant;
import xyz.carn.eventifier.model.User;
import xyz.carn.eventifier.service.ParticipantService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/participant")
public class ParticipantController {
    private final ParticipantService service;

    public ParticipantController(ParticipantService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Participant> register(@RequestBody Participant participant) {
        return ResponseEntity.ok(service.register(participant));
    }

    @PostMapping("/login")
    public ResponseEntity<Participant> login(@RequestBody User credentials) {
        return service.login(credentials)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }
}
