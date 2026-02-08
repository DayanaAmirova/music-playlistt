package com.example.music.playlist.service.impl;

import com.example.music.playlist.model.dto.UserDTO;
import com.example.music.playlist.model.entity.User;
import com.example.music.playlist.repository.UserRepository;
import com.example.music.playlist.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDTO create(UserDTO dto) {
        User user = User.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .age(dto.getAge())
                .email(dto.getEmail())
                .build();
        user = userRepository.save(user);
        return mapToDTO(user);
    }

    @Override
    public List<UserDTO> getAll() {
        return userRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO getById(Long id) {
        User user = userRepository.findById(id).orElseThrow();
        return mapToDTO(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    private UserDTO mapToDTO(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .age(user.getAge())
                .email(user.getEmail())
                .build();
    }
}