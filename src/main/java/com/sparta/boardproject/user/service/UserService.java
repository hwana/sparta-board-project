package com.sparta.boardproject.user.service;

import com.sparta.boardproject.user.dto.SignupRequestDto;
import com.sparta.boardproject.user.entity.User;
import com.sparta.boardproject.user.repository.UserRepository;
import com.sparta.boardproject.common.exception.CustomException;
import com.sparta.boardproject.common.exception.StatusEnum;
import java.util.Optional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void signup(SignupRequestDto signupRequestDto) {
        String username = signupRequestDto.getUsername();
        String password = passwordEncoder.encode(signupRequestDto.getPassword());

        Optional<User> checkUsername = userRepository.findByUsername(username);
        if (checkUsername.isPresent()) {
            throw new CustomException(StatusEnum.DUPLICATED_USERNAME);
        }

        User user = new User(username, password);
        userRepository.save(user);
    }
}