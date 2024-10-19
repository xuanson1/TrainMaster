package com.example.springmvc.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "exercise")
public class Exercise {

    @Id
    @Column(name = "exercise_id", length = 36)
    private String exerciseId;

    @Column(name = "exercisename", length = 255, nullable = false)
    private String exerciseName;

    // One Exercise can be part of many ExerciseOfProgram
    @OneToMany(mappedBy = "exercise", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonBackReference
    private List<ExerciseOfProgram> exercisesOfProgram;

    public Exercise() {
        this.exerciseId = UUID.randomUUID().toString();
    }

    public Exercise(String exerciseName) {
        this.exerciseId = UUID.randomUUID().toString();
        this.exerciseName = exerciseName;
    }

    // Getters and Setters
    public String getExerciseId() {
        return exerciseId;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public List<ExerciseOfProgram> getExercisesOfProgram() {
        return exercisesOfProgram;
    }

    public void setExercisesOfProgram(List<ExerciseOfProgram> exercisesOfProgram) {
        this.exercisesOfProgram = exercisesOfProgram;
    }
}
