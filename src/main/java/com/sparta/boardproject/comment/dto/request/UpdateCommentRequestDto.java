package com.sparta.boardproject.comment.dto.request;

import com.sparta.boardproject.comment.entity.Comment;
import com.sparta.boardproject.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCommentRequestDto {
    private String comment;
}
