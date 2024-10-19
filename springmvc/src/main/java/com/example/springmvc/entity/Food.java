package com.example.springmvc.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "food")
public class Food {

    @Id
    @Column(name = "food_id", length = 36)
    private String foodId;

    @Column(name = "food_name", length = 255, nullable = false)
    private String foodName;

    @Column(name = "notes", length = 255)
    private String notes;

    @Column(name = "kcal")
    private Float kcal;

    @Column(name = "protein")
    private Float protein;

    @Column(name = "carb")
    private Float carb;

    @Column(name = "fat")
    private Float fat;

    // One Food can be included in Many FoodOfMeal
    @OneToMany(mappedBy = "food", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonBackReference
    private List<FoodOfMeal> foodOfMeals;

    public Food() {
        this.foodId = UUID.randomUUID().toString();
    }

    public Food(String foodName, String notes, Float kcal, Float protein, Float carb, Float fat) {
        this.foodId = UUID.randomUUID().toString();
        this.foodName = foodName;
        this.notes = notes;
        this.kcal = kcal;
        this.protein = protein;
        this.carb = carb;
        this.fat = fat;
    }

    // Getters and Setters
    public String getFoodId() {
        return foodId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Float getKcal() {
        return kcal;
    }

    public void setKcal(Float kcal) {
        this.kcal = kcal;
    }

    public Float getProtein() {
        return protein;
    }

    public void setProtein(Float protein) {
        this.protein = protein;
    }

    public Float getCarb() {
        return carb;
    }

    public void setCarb(Float carb) {
        this.carb = carb;
    }

    public Float getFat() {
        return fat;
    }

    public void setFat(Float fat) {
        this.fat = fat;
    }

    public List<FoodOfMeal> getFoodOfMeals() {
        return foodOfMeals;
    }

    public void setFoodOfMeals(List<FoodOfMeal> foodOfMeals) {
        this.foodOfMeals = foodOfMeals;
    }
}
