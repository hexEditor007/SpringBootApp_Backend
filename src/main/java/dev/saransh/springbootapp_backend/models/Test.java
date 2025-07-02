package dev.saransh.springbootapp_backend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Test {
    @Id
    Integer id;
    String message;
}
