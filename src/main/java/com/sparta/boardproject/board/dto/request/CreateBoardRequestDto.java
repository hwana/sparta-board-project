package com.sparta.boardproject.board.dto.request;

import com.sparta.boardproject.user.entity.User;
import com.sparta.boardproject.board.entity.Board;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CreateBoardRequestDto {
	private String title;
	private String content;

	public Board toEntity(User user) {
		return Board.builder()
			.title(title)
			.content(content)
			.user(user)
			.build();
	}
}
