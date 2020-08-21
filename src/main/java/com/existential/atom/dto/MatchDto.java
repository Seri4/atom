package com.existential.atom.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MatchDto {
    private Long id;
    private String externalId;
    private List<TeamDto> teams;
}
