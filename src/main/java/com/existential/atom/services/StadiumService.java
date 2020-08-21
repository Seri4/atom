package com.existential.atom.services;

import com.existential.atom.dto.StadiumDto;
import org.springframework.security.access.annotation.Secured;

import java.util.List;
import java.util.Optional;

public interface StadiumService {
    /**
     * Возвращает стадион по идентификатору.
     *
     * @param id идентификатор
     * @return стадион
     */
    Optional<StadiumDto> findById(Long id);

    /***
     * Возвращает список всех стадионов.
     *
     * @return список стадионов
     */
    List<StadiumDto> findAll();

    /**
     * Удаление стадиона по id.
     *
     * @param id идентификатор
     */
    @Secured("ROLE_ADMIN")
    void deleteStadium(Long id);

    /**
     * Удаление всех стадионов.
     */
    @Secured("ROLE_ADMIN")
    void deleteAll();
}
