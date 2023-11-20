package com.sparta.boardproject.common.exception;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.security.SignatureException;
import jakarta.security.auth.message.AuthException;
import java.util.NoSuchElementException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
		String name = exception.getBindingResult().getAllErrors().get(0).getClass().getSimpleName();
		return CustomResponseEntity.toResponseEntity(StatusEnum.valueOf(name));
	}

	// security exception
	@ExceptionHandler(SignatureException.class)
	public ResponseEntity<CustomResponseEntity> handleSignatureException() {
		return CustomResponseEntity.toResponseEntity(StatusEnum.SignatureException);
	}

	@ExceptionHandler(ExpiredJwtException.class)
	public ResponseEntity<CustomResponseEntity> handleExpiredJwtException() {
		return CustomResponseEntity.toResponseEntity(StatusEnum.ExpiredJwtException);
	}

	@ExceptionHandler(UsernameNotFoundException.class)
	public ResponseEntity<CustomResponseEntity> handleUsernameNotFoundException() {
		return CustomResponseEntity.toResponseEntity(StatusEnum.UsernameNotFoundException);
	}

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<CustomResponseEntity> handleNoSuchElementException() {
		return CustomResponseEntity.toResponseEntity(StatusEnum.NoSuchElementException);
	}

	@ExceptionHandler(MalformedJwtException.class)
	public ResponseEntity<CustomResponseEntity> handleMalformedJwtException() {
		return CustomResponseEntity.toResponseEntity(StatusEnum.MalformedJwtException);
	}
}
