package com.example.springmvc.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "mealplan")
public class MealPlan {

    @Id
    @Column(name = "mealplan_id", length = 36)
    private String mealplanId;

    @Column(name = "training_status")
    private Boolean trainingStatus;

    // Many MealPlans belong to One Client
    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    @JsonIgnore
    private Client client;

    // One MealPlan has Many FoodOfMeal items
    @OneToMany(mappedBy = "mealPlan", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonBackReference
    private List<FoodOfMeal> foodOfMeals;

    public MealPlan() {
        this.mealplanId = UUID.randomUUID().toString();
    }

    public MealPlan(Boolean trainingStatus, Client client) {
        this.mealplanId = UUID.randomUUID().toString();
        this.trainingStatus = trainingStatus;
        this.client = client;
    }

    // Getters and Setters
    public String getMealplanId() {
        return mealplanId;
    }

    public void setMealplanId(String mealplanId) {
        this.mealplanId = mealplanId;
    }

    public Boolean getTrainingStatus() {
        return trainingStatus;
    }

    public void setTrainingStatus(Boolean trainingStatus) {
        this.trainingStatus = trainingStatus;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<FoodOfMeal> getFoodOfMeals() {
        return foodOfMeals;
    }

    public void setFoodOfMeals(List<FoodOfMeal> foodOfMeals) {
        this.foodOfMeals = foodOfMeals;
    }
}
