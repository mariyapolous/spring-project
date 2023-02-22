package com.example.springproject.domain.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import javax.validation.constraints.NotBlank;

import static lombok.AccessLevel.PRIVATE;

@Value
@Jacksonized
@Builder
@AllArgsConstructor(access = PRIVATE)
public class UserCreateDTO {

    @NotBlank
    String email;
    @NotBlank
    String username;
    String name;
    @NotBlank
    String password;
}
