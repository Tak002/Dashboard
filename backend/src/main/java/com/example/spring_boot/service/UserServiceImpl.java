package com.example.spring_boot.service;

import com.example.spring_boot.dto.UserDto;
import com.example.spring_boot.entity.User;
import com.example.spring_boot.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = User.builder()
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .role(userDto.getRole())
                .build();
        return entityToDto(userRepository.save(user));
    }


    @Override
    public UserDto getUserById(Long id) {
        User user =  userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with ID: " + id));
        return entityToDto(user);

    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(this::entityToDto)
                .toList();
    }

    @Override
    public UserDto updateUser(Long id, UserDto userDto) {
        User user =  userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with ID: " + id));
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setRole(userDto.getRole());
        return entityToDto( userRepository.save(user));
    }
    
    //삭제 유저 존재성 여부 검사 추가 필요
    @Override
    public UserDto deleteUser(Long id) {
        userRepository.deleteById(id);
        return UserDto.builder().id(id).build();
    }

    private UserDto entityToDto(User user){
        return UserDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .password(user.getPassword())
                .role(user.getRole())
                .build();
    }

    // private User dtoToEntity(UserDto userDto){
    //     return User.builder()
    //             .id(userDto.getId())
    //             .name(userDto.getName())
    //             .email(userDto.getEmail())
    //             .build();
    // }
}


