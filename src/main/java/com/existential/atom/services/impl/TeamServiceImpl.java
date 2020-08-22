package com.existential.atom.services.impl;

import com.existential.atom.dto.TeamDto;
import com.existential.atom.exception.ApplicationException;
import com.existential.atom.model.Team;
import com.existential.atom.repository.TeamRepository;
import com.existential.atom.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TeamServiceImpl implements TeamService {

    private TeamRepository teamRepository;

    @Autowired
    public TeamServiceImpl(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public Optional<TeamDto> findById(Long id) throws ApplicationException {
        return Optional.of(new TeamDto(teamRepository.findById(id).orElseThrow(ApplicationException::new)));
    }

    @Override
    public List<TeamDto> findAll() {
        return teamRepository.findAll().stream()
                .map(TeamDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteTeam(Long id) {
        teamRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        teamRepository.deleteAll();
    }

    @Override
    public void delete(TeamDto teamDto) {
        teamRepository.delete(new Team(teamDto));
    }

    @Override
    public void save(TeamDto teamDto) {
        teamRepository.save(new Team(teamDto));
    }
}
