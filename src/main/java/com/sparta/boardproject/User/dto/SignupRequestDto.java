package com.sparta.boardproject.User.dto;

import com.sparta.boardproject.User.annotation.Password;
import com.sparta.boardproject.User.annotation.Username;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SignupRequestDto {
	@Username
	private String username;
	@Password
	private String password;
}
