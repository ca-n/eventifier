package xyz.carn.eventifier.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Data
@MappedSuperclass
public class User {
    @Id
    @GeneratedValue
    private long id;

    @JsonIgnore
    @Email
    @Column(unique = true)
    private String email;

    @JsonIgnore
    private String password;

    private UserType userType;
}
