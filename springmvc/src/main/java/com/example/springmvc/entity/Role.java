package com.example.springmvc.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "role")
public class Role {
    @Id
    @Column(name = "role_id")
    private String role_id;

    @Column(name = "role_name", length = 50)
    private String role_name;

    @OneToMany(mappedBy = "role")
    private List<Account> accounts;

    public Role() {
    }

    public Role(String role_id, String role_name) {
        this.role_id = role_id;
        this.role_name = role_name;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public String getRole_id() {
        return role_id;
    }

    public void setRole_id(String role_id) {
        this.role_id = role_id;
    }
}
