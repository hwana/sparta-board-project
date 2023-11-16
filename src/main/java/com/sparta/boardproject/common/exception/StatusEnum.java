package com.sparta.boardproject.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;

@AllArgsConstructor
@Getter
public enum StatusEnum {
    BOARD_NOT_FOUND(HttpStatus.NOT_FOUND, "BOARD_NOT_FOUND","게시글이 존재하지 않습니다."),
    BOARD_NOT_MATCHED(HttpStatus.UNAUTHORIZED, "BOARD_NOT_MATCHED", "게시글을 작성한 사용자가 아닙니다."),
    SUCCESS(HttpStatus.CREATED,"SUCCESS", "회원가입에 성공하였습니다."),
    DUPLICATED_USERNAME(HttpStatus.CONFLICT, "DUPLICATED_USERNAME", "중복된 사용자 이름이 존재합니다."),

    BadCredentialsException(HttpStatus.UNAUTHORIZED, "PASSWORD_NOT_MATCHED", "비밀번호가 일치하지 않습니다."),
    UsernameNotFoundException(HttpStatus.BAD_REQUEST, "USER_NOT_FOUND","등록된 아이디가 존재하지 않습니다."),
    NoneException(HttpStatus.INTERNAL_SERVER_ERROR, "INTERNAL_SERVER_ERROR", "알 수 없는 에러 입니다."),
    SignatureException(HttpStatus.UNAUTHORIZED, "UNAUTHORIZED", "토큰이 유효하지 않습니다."),
    NoSuchElementException(HttpStatus.UNAUTHORIZED, "UNAUTHORIZED", "올바르지 않은 토큰입니다."),
    ExpiredJwtException(HttpStatus.UNAUTHORIZED, "UNAUTHORIZED", "토큰이 만료되었습니다. 다시 로그인해주세요."),
    ;

    private final HttpStatus httpStatus;
    private final String description;
    private final String message;
}
