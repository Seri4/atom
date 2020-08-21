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
}
