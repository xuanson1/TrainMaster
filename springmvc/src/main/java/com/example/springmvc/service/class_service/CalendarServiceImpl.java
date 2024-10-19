package com.example.springmvc.service.class_service;

import com.example.springmvc.dao.CalendarRespository;
import com.example.springmvc.entity.Calendar;
import com.example.springmvc.service.interface_service.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class CalendarServiceImpl implements CalendarService {

    @Override
    public List<Calendar> getAllCalendars() {
        return List.of();
    }

    @Override
    public Optional<Calendar> getCalendarById(int id) {
        return Optional.empty();
    }

    @Override
    public Calendar addCalendar(Calendar client) {
        return null;
    }

    @Override
    public Calendar updateCalendar(Calendar client) {
        return null;
    }

    @Override
    public Calendar deleteCalendarById(int id) {
        return null;
    }
}