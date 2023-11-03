package com.sparta.boardproject.board.dto.request;

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

	private String name;

	private String password;

	public Board toEntity() {
		return Board.builder()
			.title(title)
			.content(content)
			.name(name)
			.password(password)
			.build();
	}
}
