package com.sparta.boardproject.comment.controller;

import com.sparta.boardproject.comment.dto.request.UpdateCommentRequestDto;
import com.sparta.boardproject.comment.dto.response.CommentResponseDto;
import com.sparta.boardproject.comment.dto.request.CreateCommentRequestDto;
import com.sparta.boardproject.comment.entity.Comment;
import com.sparta.boardproject.comment.service.CommentService;
import com.sparta.boardproject.config.security.UserDetailsImpl;
import java.net.http.HttpResponse.ResponseInfo;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/comment")
public class CommentController {

    private final CommentService commentService;


    /**
     * 댓글 등록
     * @param createCommentRequestDto
     * @param userDetails
     * @return
     */
    @PostMapping
    public ResponseEntity<CommentResponseDto> createComment(@RequestBody CreateCommentRequestDto createCommentRequestDto, @AuthenticationPrincipal UserDetailsImpl userDetails){
        Comment comment = commentService.createComment(createCommentRequestDto, userDetails.getUser());
        return ResponseEntity.status(HttpStatus.CREATED).body(new CommentResponseDto(comment));
    }

    /**
     * 댓글 수정
     * @param updateCommentRequestDto
     * @param id
     * @return
     */
    @PatchMapping("/{id}")
    public ResponseEntity<CommentResponseDto> updateComment(@RequestBody UpdateCommentRequestDto updateCommentRequestDto, @PathVariable long id){
        Comment comment = commentService.updateComment(updateCommentRequestDto, id);
        return ResponseEntity.status(HttpStatus.OK).body(new CommentResponseDto(comment));
    }

    /**
     * 댓글 삭제
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable long id){
        commentService.deleteComment(id);
        return ResponseEntity.ok().build();
    }
}
