package com.existential.atom.repository;

import com.existential.atom.model.Match;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository extends JpaRepository<Long, Match> {
}
