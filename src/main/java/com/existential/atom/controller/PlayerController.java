package com.existential.atom.controller;

import com.existential.atom.dto.PlayerDto;
import com.existential.atom.exception.ApplicationException;
import com.existential.atom.services.PlayerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlayerController {

    private static final Logger log = LoggerFactory.getLogger(PlayerController.class);

    private PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/players")
    public ResponseEntity<List<PlayerDto>> findAll() {
        return new ResponseEntity<List<PlayerDto>>(playerService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/players/{id}")
    public ResponseEntity<PlayerDto> findById(@PathVariable Long id) {
        try {
            return new ResponseEntity<PlayerDto>(playerService.findById(id).orElseThrow(ApplicationException::new), HttpStatus.OK);
        } catch (ApplicationException e) {
            log.error("Something gone wrong");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/players/update")
    public void update(@RequestBody PlayerDto playerDto) {
        playerService.save(playerDto);
    }

    @DeleteMapping
    public void delete(@RequestBody PlayerDto playerDto) {
        playerService.delete(playerDto);
    }
}
