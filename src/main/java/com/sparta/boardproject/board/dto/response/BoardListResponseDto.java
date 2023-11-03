package com.sparta.boardproject.board.dto.response;

import com.sparta.boardproject.board.entity.Board;
import lombok.Getter;

@Getter
public class BoardListResponseDto {
	private final Long id;
	private final String title;
	private final String content;

	public BoardListResponseDto(Board board) {
		this.id = board.getId();
		this.title = board.getTitle();
		this.content = board.getContent();
	}
}
