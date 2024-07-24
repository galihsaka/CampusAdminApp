package com.enigmacamp.campusadminapp.service.impl;

import com.enigmacamp.campusadminapp.dto.request.ThesisRequest;
import com.enigmacamp.campusadminapp.dto.request.ValidateThesisRequest;
import com.enigmacamp.campusadminapp.dto.response.ThesisResponse;
import com.enigmacamp.campusadminapp.entity.Thesis;
import com.enigmacamp.campusadminapp.entity.User;
import com.enigmacamp.campusadminapp.repository.ThesisRepository;
import com.enigmacamp.campusadminapp.repository.UserRepository;
import com.enigmacamp.campusadminapp.service.ThesisService;
import com.enigmacamp.campusadminapp.util.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ThesisServiceImpl implements ThesisService {
    private ThesisRepository thesisRepository;
    private UserRepository userRepository;

    @Autowired
    public ThesisServiceImpl(ThesisRepository thesisRepository,UserRepository userRepository) {
        this.thesisRepository = thesisRepository;
        this.userRepository=userRepository;
    }
    private Thesis findThesisByIdOrThrowNotFound(String id){
        return thesisRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Thesis Not Found"));
    }
    private ThesisResponse convertToThesisResponse(Thesis thesis){
        ThesisResponse thesisResponse=new ThesisResponse();
        thesisResponse.setId(thesis.getId());
        thesisResponse.setTitle(thesis.getTitle());
        thesisResponse.setUserId(thesis.getUser().getId());
        thesisResponse.setApprovedByLecturer(thesis.getApprovedByLecturer());
        thesisResponse.setApprovedByLecturerAt(thesis.getApprovedByLecturerAt());
        thesisResponse.setRejectedByLecturer(thesis.getRejectedByLecturer());
        thesisResponse.setRejectedByLecturerAt(thesis.getRejectedByLecturerAt());
        thesisResponse.setApprovedByDepartment(thesis.getApprovedByDepartment());
        thesisResponse.setApprovedByDepartmentAt(thesis.getApprovedByDepartmentAt());
        thesisResponse.setRejectedByDepartment(thesis.getRejectedByDepartment());
        thesisResponse.setRejectedByDepartmentAt(thesis.getRejectedByDepartmentAt());
        return thesisResponse;
    }

    @Override
    public ThesisResponse createThesis(ThesisRequest request) {
        Optional<User> user=userRepository.findById(request.getUserId());
        Thesis thesis=new Thesis();
        thesis.setTitle(request.getTitle());
        thesis.setUser(user.orElseThrow(()->new ResourceNotFoundException("User Not Found")));
        thesis.setApprovedByLecturer(null);
        thesis.setApprovedByLecturerAt(null);
        thesis.setApprovedByDepartment(null);
        thesis.setApprovedByDepartmentAt(null);
        thesis.setRejectedByDepartment(null);
        thesis.setRejectedByDepartmentAt(null);
        thesis.setRejectedByLecturer(null);
        thesis.setRejectedByLecturerAt(null);
        thesis=thesisRepository.save(thesis);
        return convertToThesisResponse(thesis);
    }

    @Override
    public ThesisResponse findThesisById(String id) {
        return convertToThesisResponse(findThesisByIdOrThrowNotFound(id));
    }

    @Override
    public List<ThesisResponse> viewAllThesis() {
        List<Thesis> thesisList = thesisRepository.findAll();
        return thesisList.stream().map(this::convertToThesisResponse).toList();
    }

    @Override
    public ThesisResponse approveThesisByLecturer(String username, ValidateThesisRequest request) {
        Thesis thesis=findThesisByIdOrThrowNotFound(request.getThesisId());
        thesis.setApprovedByLecturer(username);
        thesis.setApprovedByLecturerAt(new Date());
        thesis.setRejectedByLecturer(null);
        thesis.setRejectedByLecturerAt(null);
        thesis=thesisRepository.save(thesis);
        return convertToThesisResponse(thesis);
    }

    @Override
    public ThesisResponse rejectThesisByLecturer(String username, ValidateThesisRequest request) {
        Thesis thesis=findThesisByIdOrThrowNotFound(request.getThesisId());
        thesis.setApprovedByLecturer(null);
        thesis.setApprovedByLecturerAt(null);
        thesis.setRejectedByLecturer(username);
        thesis.setRejectedByLecturerAt(new Date());
        thesis=thesisRepository.save(thesis);
        return convertToThesisResponse(thesis);
    }

    @Override
    public ThesisResponse approveThesisByDepartment(String username, ValidateThesisRequest request) {
        Thesis thesis=findThesisByIdOrThrowNotFound(request.getThesisId());
        thesis.setApprovedByDepartment(username);
        thesis.setApprovedByDepartmentAt(new Date());
        thesis.setRejectedByDepartment(null);
        thesis.setRejectedByDepartmentAt(null);
        thesis=thesisRepository.save(thesis);
        return convertToThesisResponse(thesis);
    }

    @Override
    public ThesisResponse rejectThesisByDepartment(String username, ValidateThesisRequest request) {
        Thesis thesis=findThesisByIdOrThrowNotFound(request.getThesisId());
        thesis.setApprovedByDepartment(null);
        thesis.setApprovedByDepartmentAt(null);
        thesis.setRejectedByDepartment(username);
        thesis.setRejectedByDepartmentAt(new Date());
        thesis=thesisRepository.save(thesis);
        return convertToThesisResponse(thesis);
    }

}
