package xyz.carn.eventifier.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Event {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String description;
    @ManyToOne
    private Organizer organizer;
    @ManyToMany
    private Set<Participant> participants;
}
