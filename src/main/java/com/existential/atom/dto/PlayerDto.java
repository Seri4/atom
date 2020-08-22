package com.existential.atom.dto;

import com.existential.atom.model.Player;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlayerDto {
    private Long id;
    private String externalId;
    private String name;
    private String type;    // голкипер, вратарь, нападающий и т.д.
    private Integer age;
    private String country;
    private TeamDto team;

    public PlayerDto(Player item) {
        this.id = item.getId();
        this.externalId = item.getExternalId();
        this.name = item.getName();
        this.type = item.getPlayerType().getValue();
        this.age = LocalDate.now().getYear() - item.getBirthDate().getYear();
        this.country = item.getCountry();
        this.team = new TeamDto(item.getTeam());
    }
}
