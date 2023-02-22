package com.example.springproject.domain.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import static lombok.AccessLevel.PRIVATE;


@Value
@Jacksonized
@Builder
@AllArgsConstructor(access = PRIVATE)
public class UserUpdateDTO {
    String email;
    String username;
    String name;
}
