package com.sparta.boardproject.comment.dto.response;

import com.sparta.boardproject.comment.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class CommentResponseDto {
    private final String comment;

    public CommentResponseDto(Comment comment){
        this.comment = comment.getComment();
    }
}
