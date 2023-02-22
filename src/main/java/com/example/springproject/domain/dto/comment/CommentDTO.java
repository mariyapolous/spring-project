package com.example.springproject.domain.dto.comment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import java.util.Date;

import static lombok.AccessLevel.PRIVATE;

@Value
@Jacksonized
@Builder
@AllArgsConstructor(access = PRIVATE)
public class CommentDTO {
    String title;
    String text;
    Date createdAt;
    Date updatedAt;
    String username;
}
