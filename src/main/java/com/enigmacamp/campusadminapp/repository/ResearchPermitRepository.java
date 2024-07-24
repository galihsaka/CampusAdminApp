package com.enigmacamp.campusadminapp.repository;

import com.enigmacamp.campusadminapp.entity.ResearchPermit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResearchPermitRepository extends JpaRepository<ResearchPermit, String> {
}
