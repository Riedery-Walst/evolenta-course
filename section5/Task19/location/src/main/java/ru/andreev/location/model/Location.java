package ru.andreev.location.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "locations")
public class Location {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private float latitude;
    private float longitude;
}
