package com.sparta.boardproject.board.repository;

import com.sparta.boardproject.board.entity.Board;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {

	List<Board> findAllByOrderByCreatedAtDesc();
	Optional<Board> findByIdAndUserId(Long id, Long UserId);
}
