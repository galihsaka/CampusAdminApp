package com.enigmacamp.campusadminapp.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "m_research")
public class ResearchPermit {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @ManyToOne
    @JoinColumn(name = "thesis_id")
    private Thesis thesis;
    private String recipient;
    private String agencyName;
    private String agencyAddress;
    private Date researchStart;
    private Date researchEnd;
    private Date researchProposeCreated;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getResearchStart() {
        return researchStart;
    }

    public void setResearchStart(Date researchStart) {
        this.researchStart = researchStart;
    }

    public Date getResearchEnd() {
        return researchEnd;
    }

    public void setResearchEnd(Date researchEnd) {
        this.researchEnd = researchEnd;
    }

    public Date getResearchProposeCreated() {
        return researchProposeCreated;
    }

    public void setResearchProposeCreated(Date researchProposeCreated) {
        this.researchProposeCreated = researchProposeCreated;
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

    public Thesis getThesis() {
        return thesis;
    }

    public void setThesis(Thesis thesis) {
        this.thesis = thesis;
    }
}
