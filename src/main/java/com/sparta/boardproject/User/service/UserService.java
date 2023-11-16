package com.sparta.boardproject.User.service;

import com.sparta.boardproject.User.dto.LoginRequestDto;
import com.sparta.boardproject.User.dto.SignupRequestDto;
import com.sparta.boardproject.User.entity.User;
import com.sparta.boardproject.User.repository.UserRepository;
import com.sparta.boardproject.common.exception.CustomException;
import com.sparta.boardproject.common.exception.StatusEnum;
import com.sparta.boardproject.config.jwt.JwtUtil;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Optional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
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