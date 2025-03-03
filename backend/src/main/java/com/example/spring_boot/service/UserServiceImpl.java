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
                .name(userDto.getName())
                .email(userDto.getEmail())
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
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        return entityToDto( userRepository.save(user));
    }

    @Override
    public UserDto deleteUser(Long id) {
        userRepository.deleteById(id);
        return UserDto.builder().id(id).build();
    }

    private UserDto entityToDto(User user){
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
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


