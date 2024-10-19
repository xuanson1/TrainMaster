    package com.example.springmvc.entity;

    import jakarta.persistence.*;
    import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

    import java.time.LocalDateTime;

    @Entity
    @Table(name = "account")
    public class Account {
        @Id
        @Column(name = "account_id",length = 36)
        private String accountId;

        @Column(name = "username", length = 50)
        private String username;

        @Column(name = "password", length = 255)
        private String password;

        @Column(name = "last_login")
        private LocalDateTime lastLogin;

        //Security
        private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        //Relationship for All table

        @ManyToOne
        @JoinColumn(name = "role_id")
        private Role role;

        @OneToOne(mappedBy = "account",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
        private Owner owner;

        @OneToOne(mappedBy = "account",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
        private FitnessManager fitnessManager;

        @OneToOne(mappedBy = "account",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
        private PersonalTrainer personalTrainer;

        @OneToOne(mappedBy = "account",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
        private Client client;

        public Account() {
        }

        public Account(String accountId, String username, String password, LocalDateTime lastLogin, Role role) {
            this.accountId = accountId;
            this.username = username;
            setPassword(password);
            this.lastLogin = lastLogin;
            this.role = role;
        }

        public String getAccountId() {
            return accountId;
        }

        public void setAccountId(String accountId) {
            this.accountId = accountId;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = passwordEncoder.encode(password);
        }

        public LocalDateTime getLastLogin() {
            return lastLogin;
        }

        public void setLastLogin(LocalDateTime lastLogin) {
            this.lastLogin = lastLogin;
        }

        public Role getRole() {
            return role;
        }

        public void setRole(Role role) {
            this.role = role;
        }

        public Owner getOwner() {
            return owner;
        }

        public void setOwner(Owner owner) {
            this.owner = owner;
        }

        public FitnessManager getFitnessManager() {
            return fitnessManager;
        }

        public void setFitnessManager(FitnessManager fitnessManager) {
            this.fitnessManager = fitnessManager;
        }

        public PersonalTrainer getPersonalTrainer() {
            return personalTrainer;
        }

        public void setPersonalTrainer(PersonalTrainer personalTrainer) {
            this.personalTrainer = personalTrainer;
        }

        public Client getClient() {
            return client;
        }

        public void setClient(Client client) {
            this.client = client;
        }
    }
