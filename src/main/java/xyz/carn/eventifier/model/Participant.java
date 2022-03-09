package xyz.carn.eventifier.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Participant extends User {
    private String firstName;
    private String lastName;
}