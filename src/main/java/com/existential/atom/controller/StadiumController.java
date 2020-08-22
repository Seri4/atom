package com.existential.atom.controller;

import com.existential.atom.dto.StadiumDto;
import com.existential.atom.exception.ApplicationException;
import com.existential.atom.services.StadiumService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StadiumController {

    private static final Logger log = LoggerFactory.getLogger(StadiumController.class);

    private StadiumService stadiumService;

    @Autowired
    public StadiumController(StadiumService stadiumService) {
        this.stadiumService = stadiumService;
    }

    @GetMapping("/stadiums")
    public ResponseEntity<List<StadiumDto>> findAll() {
        return new ResponseEntity<List<StadiumDto>>(stadiumService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/stadiums/{id}")
    public ResponseEntity<StadiumDto> findById(@PathVariable Long id) {
        try {
            return new ResponseEntity<StadiumDto>(stadiumService.findById(id).orElseThrow(ApplicationException::new), HttpStatus.OK);
        } catch (ApplicationException e) {
            log.error("Something gone wrong");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/stadiums/update")
    public void update(@RequestBody StadiumDto stadiumDto) {
        stadiumService.save(stadiumDto);
    }

    @DeleteMapping("/stadiums/delete")
    public void delete(@RequestBody StadiumDto stadiumDto) {
        stadiumService.delete(stadiumDto);
    }
}
