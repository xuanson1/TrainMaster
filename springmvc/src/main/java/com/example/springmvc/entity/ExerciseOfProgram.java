package com.example.springmvc.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "exercise_of_program")
public class ExerciseOfProgram {

    @Id
    @Column(name = "exercise_of_program_id", length = 36)
    private String exerciseOfProgramId;

    @ManyToOne
    @JoinColumn(name = "exercise_id", nullable = false)
    @JsonIgnore
    private Exercise exercise;

    @ManyToOne
    @JoinColumn(name = "program_id", nullable = false)
    @JsonIgnore
    private Program program;

    @Column(name = "sets_standard")
    private Integer setsStandard;

    @Column(name = "reps_standard")
    private Integer repsStandard;

    // Additional fields for sets, tempo, and RIR/RPE
    @Column(name = "set1")
    private Integer set1;

    @Column(name = "set2")
    private Integer set2;

    @Column(name = "set3")
    private Integer set3;

    @Column(name = "set4")
    private Integer set4;

    @Column(name = "set5")
    private Integer set5;

    @Column(name = "tempo")
    private String tempo;

    @Column(name = "rir_rpe")
    private Float rirRpe;

    @Column(name = "loadofexercise")
    private Float loadOfExercise;

    public ExerciseOfProgram() {
        this.exerciseOfProgramId = UUID.randomUUID().toString();
    }

    public ExerciseOfProgram(Exercise exercise, Program program, Integer setsStandard, Integer repsStandard) {
        this.exerciseOfProgramId = UUID.randomUUID().toString();
        this.exercise = exercise;
        this.program = program;
        this.setsStandard = setsStandard;
        this.repsStandard = repsStandard;
    }

    // Getters and Setters
    public String getExerciseOfProgramId() {
        return exerciseOfProgramId;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    public Integer getSetsStandard() {
        return setsStandard;
    }

    public void setSetsStandard(Integer setsStandard) {
        this.setsStandard = setsStandard;
    }

    public Integer getRepsStandard() {
        return repsStandard;
    }

    public void setRepsStandard(Integer repsStandard) {
        this.repsStandard = repsStandard;
    }

    public Integer getSet1() {
        return set1;
    }

    public void setSet1(Integer set1) {
        this.set1 = set1;
    }

    public Integer getSet2() {
        return set2;
    }

    public void setSet2(Integer set2) {
        this.set2 = set2;
    }

    public Integer getSet3() {
        return set3;
    }

    public void setSet3(Integer set3) {
        this.set3 = set3;
    }

    public Integer getSet4() {
        return set4;
    }

    public void setSet4(Integer set4) {
        this.set4 = set4;
    }

    public Integer getSet5() {
        return set5;
    }

    public void setSet5(Integer set5) {
        this.set5 = set5;
    }

    public String getTempo() {
        return tempo;
    }

    public void setTempo(String tempo) {
        this.tempo = tempo;
    }

    public Float getRirRpe() {
        return rirRpe;
    }

    public void setRirRpe(Float rirRpe) {
        this.rirRpe = rirRpe;
    }

    public Float getLoadOfExercise() {
        return loadOfExercise;
    }

    public void setLoadOfExercise(Float loadOfExercise) {
        this.loadOfExercise = loadOfExercise;
    }
}
