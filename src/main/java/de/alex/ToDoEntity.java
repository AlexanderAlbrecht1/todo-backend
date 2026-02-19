package de.alex;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
public class ToDoEntity extends PanacheEntity {
    public String task;
    public boolean done;
    public LocalDate date;
}
