package xyz.carn.eventifier.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;

@MappedSuperclass
@Data
public class User {
    @Id
    @GeneratedValue
    private long id;

    @Email
    @Column(unique = true)
    private String email;

    @JsonIgnore
    private String password;
}
