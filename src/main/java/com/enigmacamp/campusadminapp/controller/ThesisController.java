package com.enigmacamp.campusadminapp.controller;

import com.enigmacamp.campusadminapp.dto.request.ThesisRequest;
import com.enigmacamp.campusadminapp.dto.request.ValidateThesisRequest;
import com.enigmacamp.campusadminapp.dto.response.CommonResponse;
import com.enigmacamp.campusadminapp.dto.response.ThesisResponse;
import com.enigmacamp.campusadminapp.service.ThesisService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sisadmin/api/thesis")
public class ThesisController {
    private ThesisService thesisService;

    public ThesisController(ThesisService thesisService) {
        this.thesisService = thesisService;
    }

    private CommonResponse<ThesisResponse> generateCommonResponse(Integer code, String message, Optional<ThesisResponse> response){
        CommonResponse<ThesisResponse> commonResponse=new CommonResponse<>();
        commonResponse.setStatusCode(code);
        commonResponse.setMessage(message);
        commonResponse.setData(response);
        return commonResponse;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('STUDENT')")
    public ResponseEntity<CommonResponse<ThesisResponse>> createThesis(@RequestBody ThesisRequest request){
        ThesisResponse thesisResponse= thesisService.createThesis(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(generateCommonResponse(HttpStatus.CREATED.value(), "Thesis Registered Succesfully", Optional.of(thesisResponse)));
    }

    @PatchMapping("/approve")
    @PreAuthorize("hasAuthority('LECTURER')")
    public ResponseEntity<CommonResponse<ThesisResponse>> approveThesisByLecturer(@RequestBody ValidateThesisRequest request, HttpServletRequest servletRequest){
        String username= (String) servletRequest.getAttribute("username");
        ThesisResponse thesisResponse= thesisService.approveThesisByLecturer(username, request);
        return ResponseEntity.ok(generateCommonResponse(HttpStatus.OK.value(), "Thesis Approved", Optional.of(thesisResponse)));
    }

    @PatchMapping("/reject")
    @PreAuthorize("hasAuthority('LECTURER')")
    public ResponseEntity<CommonResponse<ThesisResponse>> rejectThesisByLecturer(@RequestBody ValidateThesisRequest request, HttpServletRequest servletRequest){
        String username= (String) servletRequest.getAttribute("username");
        ThesisResponse thesisResponse= thesisService.rejectThesisByLecturer(username, request);
        return ResponseEntity.ok(generateCommonResponse(HttpStatus.OK.value(), "Thesis Rejected", Optional.of(thesisResponse)));
    }

    @PatchMapping("/approvefinal")
    @PreAuthorize("hasAuthority('HEAD_DEPARTMENT')")
    public ResponseEntity<CommonResponse<ThesisResponse>> approveThesisByDepartment(@RequestBody ValidateThesisRequest request, HttpServletRequest servletRequest){
        String username= (String) servletRequest.getAttribute("username");
        ThesisResponse thesisResponse= thesisService.approveThesisByDepartment(username, request);
        return ResponseEntity.ok(generateCommonResponse(HttpStatus.OK.value(), "Thesis Approved", Optional.of(thesisResponse)));
    }

    @PatchMapping("/rejectfinal")
    @PreAuthorize("hasAuthority('HEAD_DEPARTMENT')")
    public ResponseEntity<CommonResponse<ThesisResponse>> rejectThesisByDepartment(@RequestBody ValidateThesisRequest request, HttpServletRequest servletRequest){
        String username= (String) servletRequest.getAttribute("username");
        ThesisResponse thesisResponse= thesisService.rejectThesisByDepartment(username, request);
        return ResponseEntity.ok(generateCommonResponse(HttpStatus.OK.value(), "Thesis Rejected", Optional.of(thesisResponse)));
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('STUDENT', 'HEAD_DEPARTMENT', 'LECTURER')")
    public ResponseEntity<CommonResponse<List<ThesisResponse>>> viewAllThesis(){
        List<ThesisResponse> thesisResponseList=thesisService.viewAllThesis();
        CommonResponse<List<ThesisResponse>> commonResponse=new CommonResponse<>();
        commonResponse.setStatusCode(HttpStatus.OK.value());
        commonResponse.setMessage("Success Load All Thesis Data");
        commonResponse.setData(Optional.of(thesisResponseList));
        return ResponseEntity.ok(commonResponse);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('STUDENT', 'HEAD_DEPARTMENT', 'LECTURER')")
    public ResponseEntity<CommonResponse<ThesisResponse>> findThesisById(@PathVariable String id){
        ThesisResponse thesisResponse=thesisService.findThesisById(id);
        return ResponseEntity.ok(generateCommonResponse(HttpStatus.OK.value(), "Thesis Found", Optional.of(thesisResponse)));
    }

}
