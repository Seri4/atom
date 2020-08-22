package com.existential.atom.controller;

import com.existential.atom.dto.UserDto;
import com.existential.atom.exception.ApplicationException;
import com.existential.atom.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> findAll() {
        return new ResponseEntity<List<UserDto>>(userService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable Long id) {
        try {
            return new ResponseEntity<UserDto>(userService.findById(id).orElseThrow(ApplicationException::new), HttpStatus.OK);
        } catch (ApplicationException e) {
            log.error("Something gone wrong");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/users/update")
    public void update(@RequestBody UserDto userDto) {
        userService.save(userDto);
    }

    @DeleteMapping("/users/delete")
    public void delete(@RequestBody UserDto userDto) {
        userService.delete(userDto);
    }
}
