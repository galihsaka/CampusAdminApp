package com.enigmacamp.campusadminapp.service;

import com.enigmacamp.campusadminapp.dto.request.ThesisRequest;
import com.enigmacamp.campusadminapp.dto.request.ValidateThesisRequest;
import com.enigmacamp.campusadminapp.dto.response.ThesisResponse;

import java.util.List;

public interface ThesisService {
    public ThesisResponse createThesis(ThesisRequest request);
    public ThesisResponse findThesisById(String id);
    public List<ThesisResponse> viewAllThesis();
    public ThesisResponse approveThesisByLecturer(String username, ValidateThesisRequest request);
    public ThesisResponse rejectThesisByLecturer(String username, ValidateThesisRequest request);
    public ThesisResponse approveThesisByDepartment(String username, ValidateThesisRequest request);
    public ThesisResponse rejectThesisByDepartment(String username, ValidateThesisRequest request);
}
