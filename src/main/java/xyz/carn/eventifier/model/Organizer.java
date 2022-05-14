package xyz.carn.eventifier.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class Organizer extends User {
    @Column(unique = true)
    private String name;

    public Organizer() {
        setUserType(UserType.ORGANIZER);
    }
}
