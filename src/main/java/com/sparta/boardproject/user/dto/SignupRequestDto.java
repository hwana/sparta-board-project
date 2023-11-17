package com.sparta.boardproject.user.dto;

import com.sparta.boardproject.user.annotation.Password;
import com.sparta.boardproject.user.annotation.Username;
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
