package com.sparta.boardproject.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {
	@ExceptionHandler(CustomException.class)
	public ResponseEntity<CustomResponseEntity> handleCustomException(CustomException exception){
		return CustomResponseEntity.toResponseEntity(exception.getStatusEnum());
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<CustomResponseEntity> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
		String errorMessage = exception.getBindingResult().getAllErrors().get(0).getDefaultMessage();
		return CustomResponseEntity.toResponseEntity(errorMessage, HttpStatus.BAD_REQUEST);
	}
}
