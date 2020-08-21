package com.existential.atom.services;

import com.existential.atom.dto.MatchDto;
import org.springframework.security.access.annotation.Secured;

import java.util.List;
import java.util.Optional;

public interface MatchService {
    /**
     * Возвращает матч по идентификатору.
     *
     * @param id идентификатор
     * @return матч
     */
    Optional<MatchDto> findById(Long id);

    /***
     * Возвращает список всех матчей.
     *
     * @return список матчей
     */
    List<MatchDto> findAll();

    /**
     * Удаление матча по id.
     *
     * @param id идентификатор
     */
    @Secured("ROLE_ADMIN")
    void deleteMatch(Long id);

    /**
     * Удаление всех матчей.
     */
    @Secured("ROLE_ADMIN")
    void deleteAll();
}
