package com.sparta.boardproject.board.service;

import com.sparta.boardproject.user.entity.User;
import com.sparta.boardproject.board.dto.request.CreateBoardRequestDto;
import com.sparta.boardproject.board.dto.request.UpdateBoardRequestDto;
import com.sparta.boardproject.board.dto.response.BoardListResponseDto;
import com.sparta.boardproject.board.dto.response.BoardResponseDto;
import com.sparta.boardproject.board.entity.Board;
import com.sparta.boardproject.board.repository.BoardRepository;
import com.sparta.boardproject.common.exception.CustomException;
import com.sparta.boardproject.common.exception.StatusEnum;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BoardService {

	private final BoardRepository boardRepository;

	// 게시글 등록
	public Board createBoard(CreateBoardRequestDto request, User user) {
		return boardRepository.save(request.toEntity(user));
	}

	//게시글 전체 조회
	public Map<String, List<BoardListResponseDto>> findBoardList() {

        return boardRepository.findAllByOrderByCreatedAtDesc()
				.stream()
				.map(BoardListResponseDto::new)
				.collect(Collectors.groupingBy(BoardListResponseDto::getUsername));
	}

	// 게시글 단건 조회
	public Board findBoardById(long id) {
		return boardRepository.findById(id).orElseThrow(() -> new CustomException(StatusEnum.BOARD_NOT_FOUND));
	}


	// 게시글 삭제
	@Transactional
	public void deleteBoard(long id, User user) {
		Board board = getBoardByIdAndUserId(id, user.getId());
		boardRepository.delete(board);
	}

	// 게시글 수정
	@Transactional
	public Board updateBoard(long id, UpdateBoardRequestDto request, User user) {
		Board board = getBoardByIdAndUserId(id, user.getId());
		board.update(request.getTitle(), request.getContent());
		return board;
	}

	// 게시글 작성자 여부 확인
	private Board getBoardByIdAndUserId(long id, long userId) {
		return boardRepository.findByIdAndUserId(id, userId)
				.orElseThrow(() -> new CustomException(StatusEnum.BOARD_NOT_MATCHED));
	}

	@Transactional
	public void updateBoardStatus(long id, User user) {
		Board board = getBoardByIdAndUserId(id, user.getId());
		board.updateStatus();
	}
}
