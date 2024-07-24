package com.enigmacamp.campusadminapp.service.impl;

import com.enigmacamp.campusadminapp.dto.request.ResearchPermitRequest;
import com.enigmacamp.campusadminapp.dto.response.ResearchLegalityResponse;
import com.enigmacamp.campusadminapp.dto.response.ResearchPermitResponse;
import com.enigmacamp.campusadminapp.entity.ResearchLegality;
import com.enigmacamp.campusadminapp.entity.ResearchPermit;
import com.enigmacamp.campusadminapp.repository.ResearchLegalityRepository;
import com.enigmacamp.campusadminapp.repository.ResearchPermitRepository;
import com.enigmacamp.campusadminapp.repository.ThesisRepository;
import com.enigmacamp.campusadminapp.service.ResearchPermitService;
import com.enigmacamp.campusadminapp.util.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ResearchServiceImpl implements ResearchPermitService {
    private ThesisRepository thesisRepository;
    private ResearchPermitRepository researchPermitRepository;
    private ResearchLegalityRepository researchLegalityRepository;

    @Autowired
    public ResearchServiceImpl(ThesisRepository thesisRepository, ResearchPermitRepository researchPermitRepository, ResearchLegalityRepository researchLegalityRepository) {
        this.thesisRepository = thesisRepository;
        this.researchPermitRepository = researchPermitRepository;
        this.researchLegalityRepository=researchLegalityRepository;
    }

    private ResearchPermit findResearchByIdOrThrowNotFound(String id){
        return researchPermitRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Research Permit Not Found"));
    }

    private ResearchPermitResponse convertToResponse(ResearchPermit researchPermit){
        ResearchPermitResponse researchPermitResponse=new ResearchPermitResponse();
        researchPermitResponse.setId(researchPermit.getId());
        researchPermitResponse.setThesisId(researchPermit.getThesis().getId());
        researchPermitResponse.setResearchProposeCreated(researchPermit.getResearchProposeCreated());
        researchPermitResponse.setResearchStart(researchPermit.getResearchStart());
        researchPermitResponse.setResearchEnd(researchPermit.getResearchEnd());
        researchPermitResponse.setAgencyName(researchPermit.getAgencyName());
        researchPermitResponse.setAgencyAddress(researchPermit.getAgencyAddress());
        researchPermitResponse.setRecipient(researchPermit.getRecipient());
        return researchPermitResponse;
    }

    public ResearchPermitResponse createResearch(ResearchPermitRequest request){
        ResearchPermit researchPermit=new ResearchPermit();
        researchPermit.setAgencyName(request.getAgencyName());
        researchPermit.setAgencyAddress(request.getAgencyAddress());
        researchPermit.setRecipient(request.getRecipient());
        researchPermit.setThesis(thesisRepository.findById(request.getThesisId()).orElseThrow(()->new ResourceNotFoundException("Thesis Not Found")));
        researchPermit.setResearchStart(request.getResearchStart());
        researchPermit.setResearchEnd(request.getResearchEnd());
        researchPermit.setResearchProposeCreated(new Date());
        researchPermit=researchPermitRepository.save(researchPermit);
        return convertToResponse(researchPermit);
    }

    public List<ResearchPermitResponse> findAll(){
        List<ResearchPermit> researchPermitList=researchPermitRepository.findAll();
        return researchPermitList.stream().map(this::convertToResponse).toList();
    }

    public ResearchPermitResponse findById(String id){
        ResearchPermit researchPermit=findResearchByIdOrThrowNotFound(id);
        return convertToResponse(researchPermit);
    }

    public ResearchPermitResponse updateResearchPermitPatch(String id, ResearchPermitRequest request){
        ResearchPermit researchPermit=findResearchByIdOrThrowNotFound(id);
        if(request.getRecipient()!=null){
            researchPermit.setRecipient(request.getRecipient());
        }
        if(request.getAgencyName()!=null){
            researchPermit.setAgencyName(request.getAgencyName());
        }
        if(request.getAgencyAddress()!=null){
            researchPermit.setAgencyAddress(request.getAgencyAddress());
        }
        if(request.getResearchStart()!=null){
            researchPermit.setResearchStart(request.getResearchStart());
        }
        if(request.getResearchEnd()!=null){
            researchPermit.setResearchEnd(request.getResearchEnd());
        }
        researchPermit=researchPermitRepository.save(researchPermit);
        return convertToResponse(researchPermit);
    }

    public void deleteResearchPermit(String id){
        ResearchPermit researchPermit=findResearchByIdOrThrowNotFound(id);
        researchPermitRepository.delete(researchPermit);
    }

    public ResearchLegalityResponse uploadDocument(String id, MultipartFile file){
        ResearchPermit researchPermit=findResearchByIdOrThrowNotFound(id);
        ResearchLegality researchLegality;
        String oriFileName= file.getOriginalFilename();
        String fileName=id+"_"+oriFileName;
        Optional<ResearchLegality> researchLegalityOptional=researchLegalityRepository.findByName(fileName);
        ResearchLegality researchLegality1=researchLegalityOptional.orElse(null);
        if(researchLegality1==null){
            researchLegality=new ResearchLegality();
        }
        else{
            researchLegality=researchLegality1;
        }
        researchLegality.setName(fileName);
        researchLegality.setResearchPermit(researchPermit);
        try{
            Path fileStorageLocation=Path.of("assets/file/");
            Path targetLocation=fileStorageLocation.resolve(fileName);
            researchLegality.setUrl(targetLocation.toString());
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
        }catch(IOException e){
            throw new RuntimeException(e);
        }
        researchLegality=researchLegalityRepository.save(researchLegality);
        ResearchLegalityResponse response=new ResearchLegalityResponse();
        response.setId(researchLegality.getId());
        response.setName(researchLegality.getName());
        response.setUrl(researchLegality.getUrl());
        response.setResearchPermitId(researchLegality.getResearchPermit().getId());
        return response;
    }
}
