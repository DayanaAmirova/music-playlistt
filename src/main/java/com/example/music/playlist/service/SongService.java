package com.example.music.playlist.service;

import com.example.music.playlist.model.dto.SongDTO;
import java.util.List;

public interface SongService {
    SongDTO create(SongDTO dto);
    SongDTO getById(Long id);
    List<SongDTO> getAll();
}
