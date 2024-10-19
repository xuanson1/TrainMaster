package com.example.springmvc.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "training_package_of_clients")
public class TrainingPackageOfClients {
    @Id
    @Column(name = "training_package_of_clients_id", length = 36)
    private String trainingPackageOfClientsId;

    @Column(name = "package_id", length = 36)
    private String packageId;

    @Column(name = "client_id", length = 36)
    private String clientId;

    @Column(name = "startdate")
    private LocalDate startDate;

    @Column(name = "remainsession")
    private int remainSession;

    // Constructor không tham số
    public TrainingPackageOfClients() {

    }

    // Constructor có tham số
    public TrainingPackageOfClients(String trainingPackageOfClientsId, String packageId, String clientId, LocalDate startDate, Integer remainSession) {
        this.trainingPackageOfClientsId = trainingPackageOfClientsId;
        this.packageId = packageId;
        this.clientId = clientId;
        this.startDate = startDate;
        this.remainSession = remainSession;
    }

    // Getter và Setter
    public String getTrainingPackageOfClientsId() {
        return trainingPackageOfClientsId;
    }

    public void setTrainingPackageOfClientsId(String trainingPackageOfClientsId) {
        this.trainingPackageOfClientsId = trainingPackageOfClientsId;
    }

    public String getPackageId() {
        return packageId;
    }

    public void setPackageId(String packageId) {
        this.packageId = packageId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public int getRemainSession() {
        return remainSession;
    }

    public void setRemainSession(int remainSession) {
        this.remainSession = remainSession;
    }
}