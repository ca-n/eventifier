package xyz.carn.eventifier.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Organizer extends User {
    @Column(unique = true)
    private String name;
}
