package com.enigmacamp.campusadminapp.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "t_research_document")
public class ResearchLegality {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private String url;
    @ManyToOne
    @JoinColumn(name = "research_id")
    private ResearchPermit researchPermit;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ResearchPermit getResearchPermit() {
        return researchPermit;
    }

    public void setResearchPermit(ResearchPermit researchPermit) {
        this.researchPermit = researchPermit;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
