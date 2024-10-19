package com.example.springmvc.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "clients_tracking")
public class ClientsTracking {

    @Id
    @Column(name = "tracking_id",length = 36)
    private String trackingId;

    @Column(name = "client_id", length = 36)
    private String clientId;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "weight")
    private float weight;

    @Column(name = "sleep_hour")
    private float sleepHour;

    @Column(name = "step_count")
    private int stepCount;

    @Column(name = "notes", length = 255)
    private String notes;

    // Constructor không tham số
    public ClientsTracking() {

    }

    // Constructor có tham số
    public ClientsTracking(String trackingId, String clientId, LocalDate date, float weight, float sleepHour, int stepCount, String notes) {
        this.trackingId = trackingId;
        this.clientId = clientId;
        this.date = date;
        this.weight = weight;
        this.sleepHour = sleepHour;
        this.stepCount = stepCount;
        this.notes = notes;
    }

    // Getter và Setter
    public String getTrackingId() {
        return trackingId;
    }

    public void setTrackingId(String trackingId) {
        this.trackingId = trackingId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getSleepHour() {
        return sleepHour;
    }

    public void setSleepHour(float sleepHour) {
        this.sleepHour = sleepHour;
    }

    public int getStepCount() {
        return stepCount;
    }

    public void setStepCount(int stepCount) {
        this.stepCount = stepCount;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

}
