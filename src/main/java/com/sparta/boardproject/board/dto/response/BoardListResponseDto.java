package com.sparta.boardproject.board.dto.response;

import com.sparta.boardproject.board.entity.Board;
import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class BoardListResponseDto {
	private final Long id;
	private final String title;
	private final String content;
	private final String username;
	private final boolean status;
	private final LocalDateTime createDate;

	public BoardListResponseDto(Board board) {
		this.id = board.getId();
		this.title = board.getTitle();
		this.content = board.getContent();
		this.username = board.getUser().getUsername();
		this.status = board.isStatus();
		this.createDate = board.getCreatedAt();
	}
}
