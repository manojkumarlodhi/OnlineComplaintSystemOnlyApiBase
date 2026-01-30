package com.dollop.OnlineComplaintSystem.globalExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.dollop.OnlineComplaintSystem.errorResponse.ErrorResponse;
import com.dollop.OnlineComplaintSystem.exception.AccessDenied;
import com.dollop.OnlineComplaintSystem.exception.EmailAlreadyExistsException;
import com.dollop.OnlineComplaintSystem.exception.InvalidEmailOrPassword;
import com.dollop.OnlineComplaintSystem.exception.JwtTokenExpiredException;
import com.dollop.OnlineComplaintSystem.exception.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
	public ResponseEntity<ErrorResponse> creatError(Exception ex, HttpStatus status, HttpServletRequest request) {
		ErrorResponse err = new ErrorResponse(LocalDateTime.now(), status.value(), status.getReasonPhrase(),
				ex.getMessage(), request.getRequestURI(), null);
		return new ResponseEntity<>(err, status);

	}

	@ExceptionHandler(JwtTokenExpiredException.class)
	public ResponseEntity<ErrorResponse> handleJwtTokenExpiredException(JwtTokenExpiredException ex,
			HttpServletRequest request) {
		return creatError(ex, HttpStatus.UNAUTHORIZED, request);
	}

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleResourceNotFound(ResourceNotFoundException ex,
			HttpServletRequest request) {

		return creatError(ex, HttpStatus.NOT_FOUND, request);
	}
     
	@ExceptionHandler(EmailAlreadyExistsException.class)
	public ResponseEntity<ErrorResponse>handleEmailAlready(EmailAlreadyExistsException ex,HttpServletRequest request){
		return creatError(ex, HttpStatus.CONFLICT, request);
	}
	
	  
	@ExceptionHandler(InvalidEmailOrPassword.class)
	public ResponseEntity<ErrorResponse>handleEmailorpassword(InvalidEmailOrPassword ex,HttpServletRequest request){
		return creatError(ex, HttpStatus.BAD_REQUEST, request);
	}
	
	
	@ExceptionHandler(AccessDenied.class)
	public ResponseEntity<ErrorResponse>handleAccessDenied(AccessDenied ex,HttpServletRequest request){
		return creatError(ex, HttpStatus.FORBIDDEN, request);
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> handleValidation(MethodArgumentNotValidException ex,
			HttpServletRequest request) {

		Map<String, String> fieldErrors = new HashMap<>();

		ex.getBindingResult().getFieldErrors().forEach(error -> {
			fieldErrors.put(error.getField(), error.getDefaultMessage());
		});

		ErrorResponse err = new ErrorResponse(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(),
				HttpStatus.BAD_REQUEST.getReasonPhrase(), "Validation failed", request.getRequestURI(), fieldErrors);

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}

}
