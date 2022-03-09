package xyz.carn.eventifier.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
public class Event {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String description;
    private LocalDateTime date;
    private String location;
}
