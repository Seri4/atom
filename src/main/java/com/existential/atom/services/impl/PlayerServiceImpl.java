package com.existential.atom.services.impl;

import com.existential.atom.dto.PlayerDto;
import com.existential.atom.exception.ApplicationException;
import com.existential.atom.model.Player;
import com.existential.atom.repository.PlayerRepository;
import com.existential.atom.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlayerServiceImpl implements PlayerService {

    private PlayerRepository playerRepository;

    @Autowired
    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public Optional<PlayerDto> findById(Long id) throws ApplicationException {
        return Optional.of(new PlayerDto(playerRepository.findById(id).orElseThrow(ApplicationException::new)));
    }

    @Override
    public List<PlayerDto> findAll() {
        return playerRepository.findAll().stream()
                .map(PlayerDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public void deletePlayer(Long id) {
        playerRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        playerRepository.deleteAll();
    }

    @Override
    public void delete(PlayerDto playerDto) {
        playerRepository.delete(new Player(playerDto));
    }

    @Override
    public void save(PlayerDto playerDto) {
        playerRepository.save(new Player(playerDto));
    }
}
