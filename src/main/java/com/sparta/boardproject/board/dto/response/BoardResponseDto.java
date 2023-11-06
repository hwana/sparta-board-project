package com.sparta.boardproject.board.dto.response;

import com.sparta.boardproject.board.entity.Board;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Getter
public class BoardResponseDto {
	private final Long id;
	private final String title;
	private final String content;
	private final String name;

	public BoardResponseDto(Board board) {
		this.id = board.getId();
		this.title = board.getTitle();
		this.content = board.getContent();
		this.name = board.getName();
	}
}
