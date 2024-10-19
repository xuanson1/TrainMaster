package com.example.springmvc.service.interface_service;

import com.example.springmvc.entity.MealPlan;

import java.util.List;
import java.util.Optional;

public interface MealPlanService {

    public List<MealPlan> getAllMealPlans();

    public Optional<MealPlan> getMealPlanById(String id);

    public MealPlan addMealPlan(MealPlan mealPlan);

    public MealPlan updateMealPlan(MealPlan mealPlan);

    public MealPlan deleteMealPlanById(String id);
}
