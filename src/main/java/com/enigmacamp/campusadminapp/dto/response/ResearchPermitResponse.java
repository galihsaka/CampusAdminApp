package com.enigmacamp.campusadminapp.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class ResearchPermitResponse {
    private String id;
    private String thesisId;
    private String recipient;
    private String agencyName;
    private String agencyAddress;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date researchStart;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date researchEnd;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date researchProposeCreated;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getResearchProposeCreated() {
        return researchProposeCreated;
    }

    public void setResearchProposeCreated(Date researchProposeCreated) {
        this.researchProposeCreated = researchProposeCreated;
    }

    public Date getResearchEnd() {
        return researchEnd;
    }

    public void setResearchEnd(Date researchEnd) {
        this.researchEnd = researchEnd;
    }

    public Date getResearchStart() {
        return researchStart;
    }

    public void setResearchStart(Date researchStart) {
        this.researchStart = researchStart;
    }

    public String getAgencyAddress() {
        return agencyAddress;
    }

    public void setAgencyAddress(String agencyAddress) {
        this.agencyAddress = agencyAddress;
    }

    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getThesisId() {
        return thesisId;
    }

    public void setThesisId(String thesisId) {
        this.thesisId = thesisId;
    }
}
