package org.aiesec.aicapp.service.impl;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aiesec.aicapp.dto.UserDto;
import org.aiesec.aicapp.entity.User;
import org.aiesec.aicapp.error.exception.EntityNotFoundException;
import org.aiesec.aicapp.repository.UserRepository;
import org.aiesec.aicapp.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Builder
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    
    private final UserRepository userRepository;
    
    @Override
    public User createUser(UserDto userDto) {
        if (userRepository.findByEmail(userDto.getEmail()).isPresent()) {
            throw new EntityNotFoundException("User with email" + userDto.getEmail() + " already exists!");
        }

        return userRepository.save(User.builder()
                .email(userDto.getEmail())
                .username(userDto.getUsername())
                .userCreationDate(userDto.getUserCreationDate())
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .password(userDto.getPassword())
                .build());
    }

    @Override
    public User findUserById(UUID userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isEmpty()) {
            throw new EntityNotFoundException("User with id " + userId + " not found!");
        }
        return user.get();
    }
}
