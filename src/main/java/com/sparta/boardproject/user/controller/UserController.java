package com.sparta.boardproject.user.controller;

import com.sparta.boardproject.user.dto.SignupRequestDto;
import com.sparta.boardproject.user.service.UserService;
import com.sparta.boardproject.common.exception.CustomResponseEntity;
import com.sparta.boardproject.common.exception.StatusEnum;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;

	@PostMapping("/user/signup")
	public ResponseEntity<CustomResponseEntity> signup(@Valid @RequestBody SignupRequestDto signupRequestDto) {
		userService.signup(signupRequestDto);
		return CustomResponseEntity.toResponseEntity(StatusEnum.SUCCESS);
	}
}