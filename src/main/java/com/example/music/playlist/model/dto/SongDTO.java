package com.example.music.playlist.model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SongDTO {
    private Long id;
    private String title;
    private String artist;
    private int duration;
}
