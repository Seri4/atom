package com.existential.atom.model;

import com.existential.atom.dto.MatchDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "match")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String externalId;

    @OneToMany(mappedBy = "match", cascade = CascadeType.ALL)
    private List<Team> teams;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "stadium_id", referencedColumnName = "id")
    private Stadium stadium;

    @Column
    private Byte score1;

    @Column
    private Byte score2;

    public Match(MatchDto item) {
        this.id = item.getId();
        this.externalId = item.getExternalId();
        this.teams = item.getTeams().stream()
                .map(Team::new)
                .collect(Collectors.toList());
        this.stadium = new Stadium(item.getStadiumDto());
        this.score1 = item.getScore1();
        this.score2 = item.getScore2();
    }
}
