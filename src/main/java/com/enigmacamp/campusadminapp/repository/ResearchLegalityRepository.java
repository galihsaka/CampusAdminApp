package com.enigmacamp.campusadminapp.repository;

import com.enigmacamp.campusadminapp.entity.ResearchLegality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ResearchLegalityRepository extends JpaRepository<ResearchLegality, String> {
    @Query(value = "SELECT * FROM t_research_document WHERE name = :name", nativeQuery = true)
    Optional<ResearchLegality> findByName(@Param("name") String name);
}
