package com.example.music.playlist.model.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private String email; // Добавили 5-й атрибут
}