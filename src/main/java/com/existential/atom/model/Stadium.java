package com.existential.atom.model;

import com.existential.atom.dto.StadiumDto;
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
@Table(name = "stadium")
public class Stadium {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String externalId;

    @Column
    private String name;

    @Column
    private Integer capacity;

    @OneToMany(mappedBy = "stadium", cascade = CascadeType.ALL)
    private List<Match> matches;

    public Stadium(StadiumDto item) {
        this.id = item.getId();
        this.externalId = item.getExternalId();
        this.name = item.getName();
        this.capacity = item.getCapacity();
        this.matches = item.getMatches().stream()
                .map(Match::new)
                .collect(Collectors.toList());
    }
}
