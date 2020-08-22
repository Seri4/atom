package com.existential.atom.dto;

import com.existential.atom.model.Team;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TeamDto {
    private Long id;
    private String externalId;
    private String name;
    private List<PlayerDto> players;
    private String country;
    private MatchDto matchDto;

    public TeamDto(Team item) {
        this.id = item.getId();
        this.externalId = item.getExternalId();
        this.name = item.getName();
        this.players = item.getPlayers().stream()
                .map(PlayerDto::new)
                .collect(Collectors.toList());
        this.country = item.getCountry();
        this.matchDto = new MatchDto(item.getMatch());
    }
}
