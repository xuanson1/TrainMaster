package com.example.springmvc.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "program")
public class Program {

    @Id
    @Column(name = "program_id", length = 36)
    private String programId;

    @Column(name = "day")
    private Integer day;

    @Column(name = "week")
    private Integer week;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    @JsonIgnore
    private Client client;

    // One Program can have many Exercises
    @OneToMany(mappedBy = "program", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonBackReference
    private List<ExerciseOfProgram> exercisesOfProgram;

    public Program() {
        this.programId = UUID.randomUUID().toString();
    }

    public Program(Integer day, Integer week, Client client) {
        this.programId = UUID.randomUUID().toString();
        this.day = day;
        this.week = week;
        this.client = client;
    }

    // Getters and Setters
    public String getProgramId() {
        return programId;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Integer getWeek() {
        return week;
    }

    public void setWeek(Integer week) {
        this.week = week;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<ExerciseOfProgram> getExercisesOfProgram() {
        return exercisesOfProgram;
    }

    public void setExercisesOfProgram(List<ExerciseOfProgram> exercisesOfProgram) {
        this.exercisesOfProgram = exercisesOfProgram;
    }
}
