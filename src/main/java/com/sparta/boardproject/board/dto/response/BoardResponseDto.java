package com.sparta.boardproject.board.dto.response;

import com.sparta.boardproject.User.entity.User;
import com.sparta.boardproject.board.entity.Board;
import lombok.Getter;

@Getter
public class BoardResponseDto {
	private final Long id;
	private final String title;
	private final String content;
	private final User user;

	public BoardResponseDto(Board board) {
		this.id = board.getId();
		this.title = board.getTitle();
		this.content = board.getContent();
		this.user= board.getUser();
	}
}
