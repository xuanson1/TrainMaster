package com.example.springmvc.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "feedback")
public class Feedback {

    @Id
    @Column(name = "feedback_id", length = 36)
    private String feedbackId;

    @Column(name = "feedback", length = 255)
    private String feedbackText;

    @Column(name = "approve")
    private Boolean approve;

    @ManyToOne
    @JoinColumn(name = "fm_id")
    @JsonIgnore
    private FitnessManager fitnessManager;

    @ManyToOne
    @JoinColumn(name = "mealplan_id")
    @JsonIgnore
    private MealPlan mealPlan;

    @ManyToOne
    @JoinColumn(name = "program_id")
    @JsonIgnore
    private Program program;

    public Feedback() {
        this.feedbackId = UUID.randomUUID().toString();
    }

    public Feedback(String feedbackText, Boolean approve, FitnessManager fitnessManager, MealPlan mealPlan, Program program) {
        this.feedbackId = UUID.randomUUID().toString();
        this.feedbackText = feedbackText;
        this.approve = approve;
        this.fitnessManager = fitnessManager;
        this.mealPlan = mealPlan;
        this.program = program;
    }

    // Getters and Setters
    public String getFeedbackId() {
        return feedbackId;
    }

    public String getFeedbackText() {
        return feedbackText;
    }

    public void setFeedbackText(String feedbackText) {
        this.feedbackText = feedbackText;
    }

    public Boolean getApprove() {
        return approve;
    }

    public void setApprove(Boolean approve) {
        this.approve = approve;
    }

    public FitnessManager getFitnessManager() {
        return fitnessManager;
    }

    public void setFitnessManager(FitnessManager fitnessManager) {
        this.fitnessManager = fitnessManager;
    }

    public MealPlan getMealPlan() {
        return mealPlan;
    }

    public void setMealPlan(MealPlan mealPlan) {
        this.mealPlan = mealPlan;
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }
}
