package de.alex;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
public class ToDoEntity extends PanacheEntity {
    Long id;
    String task;
    boolean done;
    LocalDate date;
}
