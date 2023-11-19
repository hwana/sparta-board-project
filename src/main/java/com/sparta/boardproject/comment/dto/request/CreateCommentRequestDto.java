package com.sparta.boardproject.comment.dto.request;

import com.sparta.boardproject.comment.entity.Comment;
import com.sparta.boardproject.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateCommentRequestDto {

    private long boardId;
    private String comment;

    public Comment toEntity(User user) {
        return Comment.builder().comment(comment).user(user).build();
    }
}
