package com.enigmacamp.campusadminapp.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class ThesisResponse {
    private String id;
    private String userId;
    private String title;
    private String approvedByLecturer;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date approvedByLecturerAt;
    private String rejectedByLecturer;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date rejectedByLecturerAt;
    private String approvedByDepartment;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date approvedByDepartmentAt;
    private String rejectedByDepartment;
    @JsonFormat(pattern="yyyy-MM-dd")
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
