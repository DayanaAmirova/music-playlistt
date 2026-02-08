package com.example.music.playlist.service;

import com.example.music.playlist.model.dto.UserDTO;
import java.util.List;

public interface UserService {
    UserDTO create(UserDTO dto);
    List<UserDTO> getAll();
    UserDTO getById(Long id);
    void delete(Long id);
}
