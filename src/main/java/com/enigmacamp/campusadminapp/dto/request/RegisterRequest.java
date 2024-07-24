package com.enigmacamp.campusadminapp.dto.request;

import com.enigmacamp.campusadminapp.entity.Role;
import com.enigmacamp.campusadminapp.entity.User;

import java.util.List;

public class RegisterRequest {
    private String username;
    private String password;
    private String fullName;
    private String department;
    private User.EGender gender;
    private List<Role.ERole> roles;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Role.ERole> getRoles() {
        return roles;
    }

    public void setRoles(List<Role.ERole> roles) {
        this.roles = roles;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
