package com.existential.atom.services.impl;

import com.existential.atom.dto.MatchDto;
import com.existential.atom.exception.ApplicationException;
import com.existential.atom.model.Match;
import com.existential.atom.repository.MatchRepository;
import com.existential.atom.services.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MatchServiceImpl implements MatchService {

    private MatchRepository matchRepository;

    @Autowired
    public MatchServiceImpl(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    @Override
    public Optional<MatchDto> findById(Long id) throws ApplicationException {
        return Optional.of(new MatchDto(matchRepository.findById(id).orElseThrow(ApplicationException::new)));
    }

    @Override
    public List<MatchDto> findAll() {
        return matchRepository.findAll().stream()
                .map(MatchDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteMatch(Long id) {
        matchRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        matchRepository.deleteAll();
    }

    @Override
    public void delete(MatchDto matchDto) {
        matchRepository.delete(new Match(matchDto));
    }

    @Override
    public void save(MatchDto matchDto) {
        matchRepository.save(new Match(matchDto));
    }
}
