package com.existential.atom.dto;

import com.existential.atom.model.Match;
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
public class MatchDto {
    private Long id;
    private String externalId;
    private List<TeamDto> teams;
    private StadiumDto stadiumDto;
    private Byte score1;
    private Byte score2;

    public MatchDto(Match item) {
        this.id = item.getId();
        this.externalId = item.getExternalId();
        this.teams = item.getTeams().stream()
                .map(TeamDto::new)
                .collect(Collectors.toList());
        this.stadiumDto = new StadiumDto(item.getStadium());
        this.score1 = item.getScore1();
        this.score2 = item.getScore2();
    }
}
