package com.example.music.playlist.controller;

import com.example.music.playlist.model.dto.SongDTO;
import com.example.music.playlist.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/songs")
public class SongController {
    private final SongService songService;

    @Autowired
    public SongController(SongService songService) {
        this.songService = songService;
    }

    @PostMapping
    public ResponseEntity<SongDTO> create(@RequestBody SongDTO dto) {
        return ResponseEntity.ok(songService.create(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SongDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(songService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<SongDTO>> getAll() {
        return ResponseEntity.ok(songService.getAll());
    }
}