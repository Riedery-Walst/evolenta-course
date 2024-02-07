package ru.andreev.task15.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "messages")
public class Person {
    @Id
    @GeneratedValue
    private long id;
    private String firstname;
    private String surname;
    private String lastname;
    private LocalDate birthday;
}
