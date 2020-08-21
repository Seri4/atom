package com.existential.atom.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

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
    private Stadium stadiums;

    @Column
    private Byte score1;

    @Column
    private Byte score2;
}
