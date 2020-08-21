package com.existential.atom.services;

import com.existential.atom.dto.UserDto;
import org.springframework.security.access.annotation.Secured;

import java.util.List;
import java.util.Optional;

public interface UserService {
    /**
     * Возвращает пользователя по идентификатору.
     *
     * @param id идентификатор
     * @return пользователь
     */
    Optional<UserDto> findById(Long id);

    /***
     * Возвращает список всех пользователей.
     *
     * @return список пользователей
     */
    List<UserDto> findAll();

    /**
     * Удаление пользователя по id.
     *
     * @param id идентификатор
     */
    @Secured("ROLE_ADMIN")
    void deleteUser(Long id);

    /**
     * Удаление всех пользователей.
     */
    @Secured("ROLE_ADMIN")
    void deleteAll();
}
