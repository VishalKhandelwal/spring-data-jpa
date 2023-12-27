package com.vk.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;


@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)	
	public ResponseEntity<ErrorDetail> handlerResourceNotFoundException(ResourceNotFoundException ex){
//		Map<String, Object> response = new HashMap<String, Object>();
//		response.put("message", ex.getMessage());
//		response.put("success", false);
//		response.put("status", HttpStatus.NOT_FOUND);
		String message = ex.getMessage();
		ErrorDetail response = ErrorDetail.builder().message(message).success(true).status(HttpStatus.NOT_FOUND).build();
		return new ResponseEntity<ErrorDetail>(response,HttpStatus.NOT_FOUND);
	}
	
	 @ExceptionHandler(Exception.class)
	 @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<ErrorDetail> globalExceptionHandler(Exception ex, WebRequest request){
//		Map<String, Object> response = new HashMap<String, Object>();
//		response.put("message", ex.getMessage());
//		response.put("success", false);
//		response.put("status", HttpStatus.NOT_FOUND);
		String message = ex.getMessage();
		ErrorDetail response = ErrorDetail.builder().message(message).success(true).status(HttpStatus.NOT_FOUND).build();
		return new ResponseEntity<ErrorDetail>(response,HttpStatus.NOT_FOUND);
	}
}
