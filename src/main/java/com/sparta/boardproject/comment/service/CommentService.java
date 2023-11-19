package com.sparta.boardproject.comment.service;

import com.sparta.boardproject.board.repository.BoardRepository;
import com.sparta.boardproject.comment.dto.request.CreateCommentRequestDto;
import com.sparta.boardproject.comment.dto.request.UpdateCommentRequestDto;
import com.sparta.boardproject.comment.entity.Comment;
import com.sparta.boardproject.comment.repository.CommentRepository;
import com.sparta.boardproject.common.exception.CustomException;
import com.sparta.boardproject.common.exception.StatusEnum;
import com.sparta.boardproject.user.entity.User;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;

    /**
     * 댓글 등록
     * @param createCommentRequestDto
     * @param user
     * @return
     */
    @Transactional
    public Comment createComment(CreateCommentRequestDto createCommentRequestDto, User user){
        findByBoardId(createCommentRequestDto.getBoardId());
        return commentRepository.save(createCommentRequestDto.toEntity(user));
    }

    /**
     * 댓글 수정
     * @param updateCommentRequestDto
     * @return
     */
    @Transactional
    public Comment updateComment(UpdateCommentRequestDto updateCommentRequestDto, long id){
        Comment comment = findByCommentId(id);
        comment.update(updateCommentRequestDto.getComment());
        return comment;
    }

    /**
     * 댓글 삭제
     * @param commentId
     */
    @Transactional
    public void deleteComment(long commentId){
        Comment comment = findByCommentId(commentId);
        commentRepository.delete(comment);
    }

    /**
     * 게시글 찾기
     * @param boardId
     */
    private void findByBoardId(long boardId){
        boardRepository.findById(boardId).orElseThrow(() -> new CustomException(StatusEnum.BOARD_NOT_FOUND));
    }

    /**
     * 댓글 찾기
     * @param commentId
     * @return
     */
    private Comment findByCommentId(long commentId){
        return commentRepository.findById(commentId)
                .orElseThrow(() -> new CustomException(StatusEnum.COMMENT_NOT_FOUND));
    }
}
