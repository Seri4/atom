package com.existential.atom.services.impl;

import com.existential.atom.dto.UserDto;
import com.existential.atom.exception.ApplicationException;
import com.existential.atom.model.User;
import com.existential.atom.repository.UserRepository;
import com.existential.atom.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<UserDto> findById(Long id) throws ApplicationException {
        return Optional.of(new UserDto(userRepository.findById(id).orElseThrow(ApplicationException::new)));
    }

    @Override
    public List<UserDto> findAll() {
        return userRepository.findAll().stream()
                .map(UserDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        userRepository.deleteAll();
    }

    @Override
    public void delete(UserDto userDto) {
        userRepository.delete(new User(userDto));
    }

    @Override
    public void save(UserDto userDto) {
        userRepository.save(new User(userDto));
    }
}
