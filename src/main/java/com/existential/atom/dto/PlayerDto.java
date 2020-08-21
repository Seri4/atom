package com.existential.atom.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}
