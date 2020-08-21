package com.existential.atom.repository;

import com.existential.atom.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Long, User> {
}
