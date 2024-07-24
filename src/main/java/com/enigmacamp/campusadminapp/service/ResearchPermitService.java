package com.enigmacamp.campusadminapp.service;

import com.enigmacamp.campusadminapp.dto.request.ResearchPermitRequest;
import com.enigmacamp.campusadminapp.dto.response.ResearchLegalityResponse;
import com.enigmacamp.campusadminapp.dto.response.ResearchPermitResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ResearchPermitService {
    public ResearchPermitResponse createResearch(ResearchPermitRequest request);
    public List<ResearchPermitResponse> findAll();
    public ResearchPermitResponse findById(String id);
    public ResearchPermitResponse updateResearchPermitPatch(String id, ResearchPermitRequest request);
    public void deleteResearchPermit(String id);
    public ResearchLegalityResponse uploadDocument(String id, MultipartFile file);
}
