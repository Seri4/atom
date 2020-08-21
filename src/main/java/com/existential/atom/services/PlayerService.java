package com.existential.atom.services;

import com.existential.atom.dto.PlayerDto;
import org.springframework.security.access.annotation.Secured;

import java.util.List;
import java.util.Optional;

public interface PlayerService {
    /**
     * Возвращает игрока по идентификатору.
     *
     * @param id идентификатор.
     * @return игрок.
     */
    Optional<PlayerDto> findById(Long id);

    /**
     * Возвращает список всех игроков.
     *
     * @return список игрогов
     */
    List<PlayerDto> findAll();

    /**
     * Удаление игрока по id.
     *
     * @param id идентификатор.
     */
    @Secured("ROLE_ADMIN")
    void deletePlayer(Long id);

    /**
     * Удаление всех игроков.
     */
    @Secured("ROLE_ADMIN")
    void deleteAll();
}
