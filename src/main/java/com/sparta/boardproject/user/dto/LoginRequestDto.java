package com.sparta.boardproject.user.dto;

import com.sparta.boardproject.user.annotation.Password;
import com.sparta.boardproject.user.annotation.Username;
import lombok.Getter;

@Getter
public class LoginRequestDto {
	@Username
	private String username;
	@Password
	private String password;
}
