package com.existential.atom.repository;

import com.existential.atom.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Long, Team> {
}
