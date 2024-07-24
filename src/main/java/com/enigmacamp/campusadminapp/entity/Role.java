package com.enigmacamp.campusadminapp.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "m_role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Enumerated(EnumType.STRING)
    private ERole name;

    public enum ERole {
        STUDENT,
        STAFF_ADMIN,
        SUPER_ADMIN,
        LECTURER,
        HEAD_DEPARTMENT,
        STAFF_LABORATORY
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ERole getName() {
        return name;
    }

    public void setName(ERole name) {
        this.name = name;
    }
}
