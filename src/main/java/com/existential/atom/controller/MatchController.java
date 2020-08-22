package com.existential.atom.controller;

import com.existential.atom.dto.MatchDto;
import com.existential.atom.exception.ApplicationException;
import com.existential.atom.model.Match;
import com.existential.atom.services.MatchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;

@RestController
public class MatchController {

    private static final Logger log = LoggerFactory.getLogger(MatchController.class);

    private MatchService matchService;

    @Autowired
    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @GetMapping("/matches")
    public ResponseEntity<List<MatchDto>> getAll() {
        return new ResponseEntity<List<MatchDto>>(matchService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/matches/{id}")
    public ResponseEntity<MatchDto> getById(@PathVariable Long id) {
        try {
            return new ResponseEntity<MatchDto>(matchService.findById(id).orElseThrow(ApplicationException::new), HttpStatus.OK);
        } catch (ApplicationException e) {
            log.error("Something gone wrong");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/matches/update")
    public void update(@RequestBody MatchDto matchDto) {
        matchService.save(matchDto);
    }

    @DeleteMapping("/matches/delete")
    public void delete(@RequestBody MatchDto matchDto) {
        matchService.delete(matchDto);
    }
}
