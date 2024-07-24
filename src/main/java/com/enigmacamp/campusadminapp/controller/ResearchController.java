package com.enigmacamp.campusadminapp.controller;

import com.enigmacamp.campusadminapp.dto.request.ResearchPermitRequest;
import com.enigmacamp.campusadminapp.dto.request.ThesisRequest;
import com.enigmacamp.campusadminapp.dto.response.CommonResponse;
import com.enigmacamp.campusadminapp.dto.response.ResearchLegalityResponse;
import com.enigmacamp.campusadminapp.dto.response.ResearchPermitResponse;
import com.enigmacamp.campusadminapp.dto.response.ThesisResponse;
import com.enigmacamp.campusadminapp.entity.ResearchPermit;
import com.enigmacamp.campusadminapp.service.ResearchPermitService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sisadmin/api/research")
public class ResearchController {
    private ResearchPermitService researchPermitService;

    @Autowired
    public ResearchController(ResearchPermitService researchPermitService) {
        this.researchPermitService = researchPermitService;
    }

    private CommonResponse<ResearchPermitResponse> generateCommonResponse(Integer code, String message, Optional<ResearchPermitResponse> response){
        CommonResponse<ResearchPermitResponse> commonResponse=new CommonResponse<>();
        commonResponse.setStatusCode(code);
        commonResponse.setMessage(message);
        commonResponse.setData(response);
        return commonResponse;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('STUDENT')")
    public ResponseEntity<CommonResponse<ResearchPermitResponse>> createThesis(@RequestBody ResearchPermitRequest request){
        ResearchPermitResponse researchPermitResponse= researchPermitService.createResearch(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(generateCommonResponse(HttpStatus.CREATED.value(), "Research Permit Registered Succesfully", Optional.of(researchPermitResponse)));
    }

    @PostMapping("/document/{id}")
    @PreAuthorize("hasAuthority('STAFF_ADMIN')")
    public ResponseEntity<CommonResponse<ResearchLegalityResponse>> uploadDocument(@RequestParam("file") MultipartFile multipartFile, @PathVariable String id){
        ResearchLegalityResponse researchLegalityResponse=researchPermitService.uploadDocument(id, multipartFile);
        CommonResponse<ResearchLegalityResponse> commonResponse=new CommonResponse<>();
        commonResponse.setStatusCode(HttpStatus.OK.value());
        commonResponse.setMessage("File Uploaded Successfully");
        commonResponse.setData(Optional.of(researchLegalityResponse));
        return ResponseEntity.ok(commonResponse);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('STUDENT', 'STAFF_ADMIN')")
    public ResponseEntity<CommonResponse<ResearchPermitResponse>> findById(@PathVariable String id){
        ResearchPermitResponse researchPermitResponse= researchPermitService.findById(id);
        return ResponseEntity.ok(generateCommonResponse(HttpStatus.OK.value(), "Research Permit Data Found", Optional.of(researchPermitResponse)));
    }

    @PatchMapping("/{id}")
    @PreAuthorize("hasAuthority('STUDENT')")
    public ResponseEntity<CommonResponse<ResearchPermitResponse>> update(@PathVariable String id, @RequestBody ResearchPermitRequest request){
        ResearchPermitResponse researchPermitResponse= researchPermitService.updateResearchPermitPatch(id,request);
        return ResponseEntity.ok(generateCommonResponse(HttpStatus.OK.value(), "Research Permit Data Updated Succesfully", Optional.of(researchPermitResponse)));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('STAFF_ADMIN')")
    public ResponseEntity<CommonResponse<?>> delete(@PathVariable String id){
        researchPermitService.deleteResearchPermit(id);
        return ResponseEntity.ok(generateCommonResponse(HttpStatus.OK.value(), "Research Permit Deleted Succesfully", Optional.empty()));
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('STUDENT', 'STAFF_ADMIN')")
    public ResponseEntity<CommonResponse<List<ResearchPermitResponse>>> viewAllResearchPermit(){
        List<ResearchPermitResponse> researchPermitList=researchPermitService.findAll();
        CommonResponse<List<ResearchPermitResponse>> commonResponse=new CommonResponse<>();
        commonResponse.setStatusCode(HttpStatus.OK.value());
        commonResponse.setMessage("Success Load All Research Permit Data");
        commonResponse.setData(Optional.of(researchPermitList));
        return ResponseEntity.ok(commonResponse);
    }
}
