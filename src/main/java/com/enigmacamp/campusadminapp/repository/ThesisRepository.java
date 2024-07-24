package com.enigmacamp.campusadminapp.repository;

import com.enigmacamp.campusadminapp.entity.Thesis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThesisRepository extends JpaRepository<Thesis, String> {
}
