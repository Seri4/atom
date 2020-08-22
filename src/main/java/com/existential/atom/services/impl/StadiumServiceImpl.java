package com.existential.atom.services.impl;

import com.existential.atom.dto.StadiumDto;
import com.existential.atom.exception.ApplicationException;
import com.existential.atom.model.Stadium;
import com.existential.atom.repository.StadiumRepository;
import com.existential.atom.services.StadiumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StadiumServiceImpl implements StadiumService {

    private StadiumRepository stadiumRepository;

    @Autowired
    public StadiumServiceImpl(StadiumRepository stadiumRepository) {
        this.stadiumRepository = stadiumRepository;
    }

    @Override
    public Optional<StadiumDto> findById(Long id) throws ApplicationException {
        return Optional.of(new StadiumDto(stadiumRepository.findById(id).orElseThrow(ApplicationException::new)));
    }

    @Override
    public List<StadiumDto> findAll() {
        return stadiumRepository.findAll().stream()
                .map(StadiumDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteStadium(Long id) {
        stadiumRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        stadiumRepository.deleteAll();
    }

    @Override
    public void delete(StadiumDto stadiumDto) {
        stadiumRepository.delete(new Stadium(stadiumDto));
    }

    @Override
    public void save(StadiumDto stadiumDto) {
        stadiumRepository.save(new Stadium(stadiumDto));
    }
}
