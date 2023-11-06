package com.sparta.boardproject.board.controller;

import com.sparta.boardproject.board.dto.request.CreateBoardRequestDto;
import com.sparta.boardproject.board.dto.request.UpdateBoardRequestDto;
import com.sparta.boardproject.board.dto.response.BoardResponseDto;
import com.sparta.boardproject.board.entity.Board;
import com.sparta.boardproject.board.service.BoardService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class BoardController {

	private final BoardService boardService;

	/**
	 * 게시글 작성
	 * @param request : 게시글 작성 내용
	 * @return
	 */
	@PostMapping("/board")
	public ResponseEntity<BoardResponseDto> addBoard(@RequestBody CreateBoardRequestDto request) {
		Board savedBoard = boardService.save(request);
		return ResponseEntity.status(HttpStatus.CREATED).body(new BoardResponseDto(savedBoard));
	}

	/**
	 * 전체 게시글 조회
	 * @return
	 */
	@GetMapping("/board")
	public ResponseEntity<List<BoardResponseDto>> findAllBoards() {
		List<BoardResponseDto> boards = boardService.findAll()
			.stream()
			.map(BoardResponseDto::new)
			.toList();

		return ResponseEntity.ok().body(boards);
	}

	/**
	 * 게시글 단건 조회
	 * @param id
	 * @return
	 */
	@GetMapping("/board/{id}")
	public ResponseEntity<BoardResponseDto> findBoard(@PathVariable long id) {
		Board board = boardService.findById(id);
		return ResponseEntity.ok().body(new BoardResponseDto(board));
	}

	/**
	 * 게시글 삭제
	 * @param id
	 * @return
	 */
	@DeleteMapping("/board/{id}")
	public ResponseEntity<Void> deleteBoard(@PathVariable long id, @RequestHeader String password) {
		boardService.delete(id, password);
		return ResponseEntity.ok().build();
	}

	/**
	 * 게시글 수정
	 * @param id
	 * @param request
	 * @return
	 */
	@PatchMapping("/board/{id}")
	public ResponseEntity<BoardResponseDto> updateBoard(@PathVariable long id, @RequestBody UpdateBoardRequestDto request) {
		Board updatedBoard = boardService.update(id, request);
		return ResponseEntity.ok().body(new BoardResponseDto(updatedBoard));
	}
}
