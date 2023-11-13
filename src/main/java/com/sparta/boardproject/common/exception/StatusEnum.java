package com.sparta.boardproject.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum StatusEnum {
    PASSWORD_NOT_MATCHED(HttpStatus.UNAUTHORIZED, "비밀번호가 일치하지 않습니다."),
    BOARD_NOT_FOUND(HttpStatus.NOT_FOUND, "게시글이 존재하지 않습니다."),
    SUCCESS(HttpStatus.CREATED, "회원가입에 성공하였습니다."),
    DUPLICATED_USERNAME(HttpStatus.CONFLICT, "중복된 사용자 이름이 존재합니다.");

    private final HttpStatus httpStatus;
    private final String message;
}
