package com.example.springmvc.service.interface_service;

import com.example.springmvc.entity.Calendar;
import com.example.springmvc.entity.Client;

import java.util.List;
import java.util.Optional;

public interface CalendarService {
    public List<Calendar> getAllCalendars();

    public Optional<Calendar> getCalendarById(int id);

    public Calendar addCalendar(Calendar client);

    public Calendar updateCalendar(Calendar client);

    public Calendar deleteCalendarById(int id);
}
