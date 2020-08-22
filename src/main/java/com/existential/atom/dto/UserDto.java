package com.existential.atom.dto;

import com.existential.atom.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    private Long id;
    private String externalId;
    private String name;
    private String email;
    private String password;
    private String repeatPassword;

    public UserDto(User item) {
        this.id = item.getId();
        this.externalId = item.getExternalId();
        this.name = item.getName();
        this.email = item.getEmail();
        this.password = item.getPassword();
    }
}
