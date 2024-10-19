package com.example.springmvc.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
@Entity
@Table(name = "calendar")
public class Calendar {

    @Id
    @Column(name = "calendar_id",length = 36)
    private String calendarId;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "timestart")
    private LocalTime timeStart;

    @Column(name = "timeend")
    private LocalTime timeEnd;

    @Column(name = "attendance_status")
    private boolean attendanceStatus;

    @Column(name = "client_id", columnDefinition = "CHAR(36)")
    private String clientId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    @JsonBackReference
    private Client client;

    // Constructor không tham số
    public Calendar() {
    }

    // Constructor có tham số
    public Calendar(String calendarId,LocalDate date, LocalTime timeStart, LocalTime timeEnd, boolean attendanceStatus,Client client, String clientId) {
        this.calendarId = calendarId;
        this.date = date;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.attendanceStatus = attendanceStatus;
        this.clientId = clientId;
    }

    // Getter và Setter
    public String getCalendarId() {
        return calendarId;
    }

    public void setCalendarId(String calendarId) {
        this.calendarId = calendarId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(LocalTime timeStart) {
        this.timeStart = timeStart;
    }

    public LocalTime getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(LocalTime timeEnd) {
        this.timeEnd = timeEnd;
    }

    public boolean getAttendanceStatus() {
        return attendanceStatus;
    }

    public void setAttendanceStatus(boolean attendanceStatus) {
        this.attendanceStatus = attendanceStatus;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

}