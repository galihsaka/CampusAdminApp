package com.enigmacamp.campusadminapp.dto.response;

import com.enigmacamp.campusadminapp.entity.Role;
import com.enigmacamp.campusadminapp.entity.User;

import java.util.List;

public class RegisterResponse {
    private String id;
    private String username;
    private String fullName;
    private String department;
    private User.EGender gender;
    private List<Role> roles;

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public User.EGender getGender() {
        return gender;
    }

    public void setGender(User.EGender gender) {
        this.gender = gender;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
