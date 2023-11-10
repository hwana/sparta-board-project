package com.sparta.boardproject.board.service;

import com.sparta.boardproject.board.dto.request.CreateBoardRequestDto;
import com.sparta.boardproject.board.dto.request.UpdateBoardRequestDto;
import com.sparta.boardproject.board.entity.Board;
import com.sparta.boardproject.board.repository.BoardRepository;
import com.sparta.boardproject.common.exception.CustomException;
import com.sparta.boardproject.common.exception.StatusEnum;
import jakarta.servlet.Filter;
import jakarta.transaction.Transactional;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;

@RequiredArgsConstructor
@Service
public class BoardService {

	private final BoardRepository boardRepository;

	// 게시글 등록
	public Board save(CreateBoardRequestDto request) {
		return boardRepository.save(request.toEntity());
	}

	//게시글 전체 조회
	public List<Board> findAll() {
		return boardRepository.findAllByOrderByCreatedAtDesc();
	}

	// 게시글 단건 조회
	public Board findById(long id) {
		return getBoardById(id);
	}

	// 게시글 삭제
	public void delete(long id, String password) {
		Board board = getBoardById(id);
		passwordCheck(board, password);
		boardRepository.delete(board);
	}

	// 게시글 수정
	@Transactional
	public Board update(long id, UpdateBoardRequestDto request) {
		Board board = getBoardById(id);
		passwordCheck(board, request.getPassword());
		board.update(request.getTitle(), request.getContent());
		return board;
	}

	// id로 게시글 찾기
	private Board getBoardById(long id) {
		return boardRepository.findById(id).orElseThrow(() -> new CustomException(StatusEnum.BOARD_NOT_FOUND));
	}


	// 비밀 번호 일치 여부 확인
	private void passwordCheck(Board board, String inputPassword) {
		if (!board.getPassword().equals(inputPassword)) {
			throw new CustomException(StatusEnum.PASSWORD_NOT_MATCHED);
		}
	}
}
