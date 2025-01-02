package org.example.bci_api.model;

import javax.persistence.*;
import lombok.Data;

import java.util.UUID;
import java.util.List;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    @Column(unique = true)
    private String email;

    private String password;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "user_id")
    private List<Phone> phones;

    private String created;
}
