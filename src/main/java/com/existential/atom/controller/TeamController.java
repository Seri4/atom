package com.existential.atom.controller;

import com.existential.atom.dto.TeamDto;
import com.existential.atom.exception.ApplicationException;
import com.existential.atom.services.TeamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeamController {

    private static final Logger log = LoggerFactory.getLogger(TeamController.class);

    private TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("/teams")
    public ResponseEntity<List<TeamDto>> findAll() {
        return new ResponseEntity<List<TeamDto>>(teamService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/teams/{id}")
    public ResponseEntity<TeamDto> findById(@PathVariable Long id) {
        try {
            return new ResponseEntity<TeamDto>(teamService.findById(id).orElseThrow(ApplicationException::new), HttpStatus.OK);
        } catch (ApplicationException e) {
            log.error("Something gone wrong");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/teams/update")
    public void update(@RequestBody TeamDto teamDto) {
        teamService.save(teamDto);
    }

    @DeleteMapping("/teams/delete")
    public void delete(@RequestBody TeamDto teamDto) {
        teamService.delete(teamDto);
    }
}
