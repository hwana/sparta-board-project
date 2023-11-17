package com.sparta.boardproject.board.controller;

import com.sparta.boardproject.board.dto.request.CreateBoardRequestDto;
import com.sparta.boardproject.board.dto.request.UpdateBoardRequestDto;
import com.sparta.boardproject.board.dto.response.BoardListResponseDto;
import com.sparta.boardproject.board.dto.response.BoardResponseDto;
import com.sparta.boardproject.board.entity.Board;
import com.sparta.boardproject.board.service.BoardService;
import com.sparta.boardproject.config.jwt.JwtUtil;
import com.sparta.boardproject.config.security.UserDetailsImpl;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CookieValue;
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
@RequestMapping("/api/board")
public class BoardController {

	private final BoardService boardService;


	/**
	 * 할 일 카드 작성
	 * @param request : 할 일 카드 작성 내용
	 * @return
	 */
	@PostMapping("/board")
	public ResponseEntity<BoardResponseDto> createBoard(@AuthenticationPrincipal UserDetailsImpl userDetails, @RequestBody CreateBoardRequestDto request) {
		Board savedBoard = boardService.createBoard(request, userDetails.getUser());
		return ResponseEntity.status(HttpStatus.CREATED).body(new BoardResponseDto(savedBoard));
	}

	/**
	 * 전체 할 일 카드 조회
	 * @return
	 */
	@GetMapping
	public ResponseEntity<Map<String, List<BoardListResponseDto>>> findAllBoards() {
		return ResponseEntity.ok().body(boardService.findBoardList());
	}

	/**
	 * 할 일 카드 단건 조회
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public ResponseEntity<BoardResponseDto> findBoard(@PathVariable long id) {
		Board board = boardService.findBoardById(id);
		return ResponseEntity.ok().body(new BoardResponseDto(board));
	}

	/**
	 * 할 일 카드 삭제
	 * @param id
	 * @return
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteBoard(@AuthenticationPrincipal UserDetailsImpl userDetails, @PathVariable long id) {
		boardService.deleteBoard(id, userDetails.getUser());
		return ResponseEntity.ok().build();
	}

	/**
	 * 할 일 카드 수정
	 * @param id
	 * @param request
	 * @return
	 */
	@PatchMapping("/{id}")
	public ResponseEntity<BoardResponseDto> updateBoard(@AuthenticationPrincipal UserDetailsImpl userDetails, @PathVariable long id, @RequestBody UpdateBoardRequestDto request) {
		Board updatedBoard = boardService.updateBoard(id, request, userDetails.getUser());
		return ResponseEntity.ok().body(new BoardResponseDto(updatedBoard));
	}

	/**
	 * 할 일 카드 완료처리
	 * @param id
	 * @return
	 */
	@PatchMapping("/status/{id}")
	public ResponseEntity<Void> updateBoardStatus(@AuthenticationPrincipal UserDetailsImpl userDetails, @PathVariable long id) {
		boardService.updateBoardStatus(id, userDetails.getUser());
		return ResponseEntity.ok().build();
	}
}
