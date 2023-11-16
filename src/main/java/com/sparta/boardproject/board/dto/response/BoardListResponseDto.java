package com.sparta.boardproject.board.dto.response;

import com.sparta.boardproject.User.entity.User;
import com.sparta.boardproject.board.entity.Board;
import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class BoardListResponseDto {
	private final Long id;
	private final String title;
	private final String content;
	private final User user;
	private final LocalDateTime createDate;

	public BoardListResponseDto(Board board) {
		this.id = board.getId();
		this.title = board.getTitle();
		this.content = board.getContent();
		this.user = board.getUser();
		this.createDate = board.getCreatedAt();
	}
}
