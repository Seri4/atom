package com.existential.atom.services;

import com.existential.atom.dto.PlayerDto;
import com.existential.atom.dto.TeamDto;
import com.existential.atom.exception.ApplicationException;

import java.util.List;
import java.util.Optional;

public interface TeamService {
    /**
     * Возвращает команду по идентификатору.
     *
     * @param id идентификатор
     * @return команда
     */
    Optional<TeamDto> findById(Long id) throws ApplicationException;

    /***
     * Возвращает список всех команд.
     *
     * @return список команд
     */
    List<TeamDto> findAll();

    /**
     * Удаление команды по id.
     *
     * @param id идентификатор
     */
//    @Secured("ROLE_ADMIN")
    void deleteTeam(Long id);

    /**
     * Удаление всех команд.
     */
//    @Secured("ROLE_ADMIN")
    void deleteAll();

    void delete(TeamDto teamDto);

    void save(TeamDto teamDto);
}
