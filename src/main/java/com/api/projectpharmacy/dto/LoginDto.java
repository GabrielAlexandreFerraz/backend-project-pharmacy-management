package com.api.projectpharmacy.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginDto {
    @NotBlank
    private String email;

    @NotBlank
    private String senha;


    @Override
    public String toString() {
        return "LoginDto{" +
                "email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}
