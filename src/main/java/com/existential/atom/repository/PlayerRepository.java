package com.existential.atom.repository;

import com.existential.atom.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Long, Player> {
}
