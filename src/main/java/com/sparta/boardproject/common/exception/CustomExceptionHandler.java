package com.sparta.boardproject.common.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {
	@ExceptionHandler(CustomException.class)
	public ResponseEntity<ErrorResponseEntity> handleCustomException(CustomException e){
		return ErrorResponseEntity.toResponseEntity(e.getStatusEnum());
	}
}
