package com.existential.atom.dto;

import com.existential.atom.model.Stadium;
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
public class StadiumDto {
    private Long id;
    private String externalId;
    private String name;
    private Integer capacity;
    private List<MatchDto> matches;

    public StadiumDto(Stadium item) {
        this.id = item.getId();
        this.externalId = item.getExternalId();
        this.name = item.getName();
        this.capacity = item.getCapacity();
        this.matches = item.getMatches().stream()
                .map(MatchDto::new)
                .collect(Collectors.toList());
    }
}
