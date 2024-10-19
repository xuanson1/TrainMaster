package com.example.springmvc.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "food_of_meal")
public class FoodOfMeal {

    @Id
    @Column(name = "food_of_meal_id", length = 36)
    private String foodOfMealId;

    @ManyToOne
    @JoinColumn(name = "mealplan_id", nullable = false)
    @JsonIgnore
    private MealPlan mealPlan;

    @ManyToOne
    @JoinColumn(name = "food_id", nullable = false)
    @JsonIgnore
    private Food food;

    public FoodOfMeal() {
        this.foodOfMealId = UUID.randomUUID().toString();
    }

    public FoodOfMeal(MealPlan mealPlan, Food food) {
        this.foodOfMealId = UUID.randomUUID().toString();
        this.mealPlan = mealPlan;
        this.food = food;
    }

    // Getters and Setters
    public String getFoodOfMealId() {
        return foodOfMealId;
    }

    public MealPlan getMealPlan() {
        return mealPlan;
    }

    public void setMealPlan(MealPlan mealPlan) {
        this.mealPlan = mealPlan;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }
}
