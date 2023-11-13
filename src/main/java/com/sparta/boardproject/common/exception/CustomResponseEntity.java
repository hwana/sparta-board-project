package com.sparta.boardproject.common.exception;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Data
@Builder
public class CustomResponseEntity {
	private int status;
	private String name;
	private String message;

	//enum으로 관리할 경우
	public static ResponseEntity<CustomResponseEntity> toResponseEntity(StatusEnum e){
		return ResponseEntity
			.status(e.getHttpStatus())
			.body(CustomResponseEntity.builder()
				.status(e.getHttpStatus().value())
				.name(e.name())
				.message(e.getMessage())
				.build());
	}

	//enum으로 관리가 안될 경우
	public static ResponseEntity<CustomResponseEntity> toResponseEntity(String message, HttpStatus status){
		return ResponseEntity
				.status(status)
				.body(CustomResponseEntity.builder()
						.status(status.value())
						.name(status.name())
						.message(message)
						.build());
	}
}
