package xyz.carn.eventifier.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class Admin extends User {
    public Admin() {
        setUserType(UserType.ADMIN);
    }
}
