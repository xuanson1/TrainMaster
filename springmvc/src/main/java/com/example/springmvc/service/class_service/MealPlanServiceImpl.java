package com.example.springmvc.service.class_service;

import com.example.springmvc.dao.MealPlanRepository;
import com.example.springmvc.entity.MealPlan;
import com.example.springmvc.service.interface_service.MealPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MealPlanServiceImpl implements MealPlanService {

    private final MealPlanRepository mealPlanRepository;

    @Autowired
    public MealPlanServiceImpl(MealPlanRepository mealPlanRepository) {
        this.mealPlanRepository = mealPlanRepository;
    }

    @Override
    public List<MealPlan> getAllMealPlans() {
        return this.mealPlanRepository.findAll();
    }

    @Override
    public Optional<MealPlan> getMealPlanById(String id) {
        return this.mealPlanRepository.findById(id);
    }

    @Override
    @Transactional
    public MealPlan addMealPlan(MealPlan mealPlan) {
        return this.mealPlanRepository.save(mealPlan);
    }

    @Override
    @Transactional
    public MealPlan updateMealPlan(MealPlan mealPlan) {
        return this.mealPlanRepository.saveAndFlush(mealPlan);
    }

    @Override
    @Transactional
    public MealPlan deleteMealPlanById(String id) {
        Optional<MealPlan> mealPlan = this.mealPlanRepository.findById(id);
        mealPlan.ifPresent(mp -> this.mealPlanRepository.delete(mp));
        return mealPlan.orElse(null); // Return the deleted meal plan or null if not found
    }
}
