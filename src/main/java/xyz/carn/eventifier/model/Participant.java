package xyz.carn.eventifier.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class Participant extends User {
    private String firstName;
    private String lastName;

    public Participant() {
        setUserType(UserType.PARTICIPANT);
    }
}
