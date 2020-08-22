package com.existential.atom.model;

import com.existential.atom.dto.PlayerDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "player")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String externalId;

    @Column
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "team_id", referencedColumnName = "id")
    private Team team;

    @Enumerated(EnumType.STRING)
    private PlayerType playerType;

    @Column
    private LocalDate birthDate;

    @Column
    private String country;

    public Player(PlayerDto item) {
        this.id = item.getId();
        this.externalId = item.getExternalId();
        this.name = item.getName();
        this.team = new Team(item.getTeam());
        this.playerType = PlayerType.fromText(item.getType());
        this.birthDate = LocalDate.now().minusYears(item.getAge());
        this.country = item.getCountry();
    }
}
