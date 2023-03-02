package com.example.ghuddytask;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "rental_ghuddy")
public class RentalProperty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rental_id")
    private Long id;

    @Column(name="rental_property_name")
    private String rentalPropertyName;

    public RentalProperty(){

    }

    public RentalProperty(Long id, String rentalPropertyName, LocalDate createdAt, LocalDate lastUpdate, String location) {
        this.id = id;
        this.rentalPropertyName = rentalPropertyName;
        this.createdAt = createdAt;
        this.lastUpdate = lastUpdate;
        this.location = location;
    }

    public RentalProperty(String rentalPropertyName, LocalDate createdAt, LocalDate lastUpdate, String location) {
        this.rentalPropertyName = rentalPropertyName;
        this.createdAt = createdAt;
        this.lastUpdate = lastUpdate;
        this.location = location;
    }

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column(name = "last_update")
    private LocalDate lastUpdate;

    @Column(name = "location")
    private String location;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRentalPropertyName() {
        return rentalPropertyName;
    }

    public void setRentalPropertyName(String rentalPropertyName) {
        this.rentalPropertyName = rentalPropertyName;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDate lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "RentalProperty{" +
                "id=" + id +
                ", rentalPropertyName='" + rentalPropertyName + '\'' +
                ", createdAt=" + createdAt +
                ", lastUpdate=" + lastUpdate +
                ", location='" + location + '\'' +
                '}';
    }
}
