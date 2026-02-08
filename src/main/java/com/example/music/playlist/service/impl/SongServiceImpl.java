package com.example.music.playlist.service.impl;

import com.example.music.playlist.model.dto.SongDTO;
import com.example.music.playlist.model.entity.Song;
import com.example.music.playlist.repository.SongRepository;
import com.example.music.playlist.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SongServiceImpl implements SongService {
    private final SongRepository songRepository;

    @Autowired
    public SongServiceImpl(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @Override
    public SongDTO create(SongDTO dto) {
        Song song = Song.builder()
                .title(dto.getTitle())
                .artist(dto.getArtist())
                .duration(dto.getDuration())
                .build();
        song = songRepository.save(song);
        return mapToDTO(song);
    }

    @Override
    public SongDTO getById(Long id) {
        Song song = songRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Song not found"));
        return mapToDTO(song);
    }

    @Override
    public List<SongDTO> getAll() {
        return songRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private SongDTO mapToDTO(Song song) {
        return SongDTO.builder()
                .id(song.getId())
                .title(song.getTitle())
                .artist(song.getArtist())
                .duration(song.getDuration())
                .build();
    }
}

