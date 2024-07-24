package com.enigmacamp.campusadminapp.dto.response;

public class ResearchLegalityResponse {
    private String id;
    private String url;
    private String name;
    private String researchPermitId;

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getResearchPermitId() {
        return researchPermitId;
    }

    public void setResearchPermitId(String researchPermitId) {
        this.researchPermitId = researchPermitId;
    }
}
