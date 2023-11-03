package com.sparta.boardproject.board.repository;

import com.sparta.boardproject.board.entity.Board;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {

	List<Board> findAllByOrderByCreatedAtDesc();
}
