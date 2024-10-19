package com.example.springmvc.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "training_package")
public class TrainingPackage {

    @Id
    @Column(name = "package_id", length = 36)
    private String packageId;

    @Column(name = "package_name", length = 255)
    private String packageName;

    @Column(name = "cost")
    private float cost;

    @Column(name = "sessionnumber")
    private int sessionNumber;

    @Column(name = "description", length = 255)
    private String description;

    // Constructor không tham số
    public TrainingPackage() {

    }

    // Constructor có tham số
    public TrainingPackage(String packageId, String packageName, float cost, int sessionNumber, String description) {
        this.packageId = packageId;
        this.packageName = packageName;
        this.cost = cost;
        this.sessionNumber = sessionNumber;
        this.description = description;
    }

    // Getter và Setter
    public String getPackageId() {
        return packageId;
    }

    public void setPackageId(String packageId) {
        this.packageId = packageId;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public int getSessionNumber() {
        return sessionNumber;
    }

    public void setSessionNumber(int sessionNumber) {
        this.sessionNumber = sessionNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}