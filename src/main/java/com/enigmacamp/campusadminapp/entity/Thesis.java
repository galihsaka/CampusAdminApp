package com.enigmacamp.campusadminapp.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "m_thesis")
public class Thesis {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private String title;
    private String approvedByLecturer;
    private Date approvedByLecturerAt;
    private String rejectedByLecturer;
    private Date rejectedByLecturerAt;
    private String approvedByDepartment;
    private Date approvedByDepartmentAt;
    private String rejectedByDepartment;
    private Date rejectedByDepartmentAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getRejectedByDepartmentAt() {
        return rejectedByDepartmentAt;
    }

    public void setRejectedByDepartmentAt(Date rejectedByDepartmentAt) {
        this.rejectedByDepartmentAt = rejectedByDepartmentAt;
    }

    public String getRejectedByDepartment() {
        return rejectedByDepartment;
    }

    public void setRejectedByDepartment(String rejectedByDepartment) {
        this.rejectedByDepartment = rejectedByDepartment;
    }

    public Date getApprovedByDepartmentAt() {
        return approvedByDepartmentAt;
    }

    public void setApprovedByDepartmentAt(Date approvedByDepartmentAt) {
        this.approvedByDepartmentAt = approvedByDepartmentAt;
    }

    public String getApprovedByDepartment() {
        return approvedByDepartment;
    }

    public void setApprovedByDepartment(String approvedByDepartment) {
        this.approvedByDepartment = approvedByDepartment;
    }

    public Date getRejectedByLecturerAt() {
        return rejectedByLecturerAt;
    }

    public void setRejectedByLecturerAt(Date rejectedByLecturerAt) {
        this.rejectedByLecturerAt = rejectedByLecturerAt;
    }

    public String getRejectedByLecturer() {
        return rejectedByLecturer;
    }

    public void setRejectedByLecturer(String rejectedByLecturer) {
        this.rejectedByLecturer = rejectedByLecturer;
    }

    public Date getApprovedByLecturerAt() {
        return approvedByLecturerAt;
    }

    public void setApprovedByLecturerAt(Date approvedByLecturerAt) {
        this.approvedByLecturerAt = approvedByLecturerAt;
    }

    public String getApprovedByLecturer() {
        return approvedByLecturer;
    }

    public void setApprovedByLecturer(String approvedByLecturer) {
        this.approvedByLecturer = approvedByLecturer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
