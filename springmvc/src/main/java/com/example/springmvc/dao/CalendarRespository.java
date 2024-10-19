package com.example.springmvc.dao;

import com.example.springmvc.entity.Calendar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalendarRespository extends JpaRepository<Calendar,Integer> {
}
