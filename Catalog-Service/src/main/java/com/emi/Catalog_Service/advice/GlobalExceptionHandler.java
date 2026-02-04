package com.emi.Catalog_Service.advice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.emi.Catalog_Service.ServiceImpl.BookDeletedException;
import com.emi.Catalog_Service.exception.BookNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(BookNotFoundException.class)
	public ResponseEntity<?> hanndleBookNotFound(BookNotFoundException ex){
		return ResponseEntity
				.status(404)
				.body(ex.getMessage());
	}
	
	@ExceptionHandler(BookDeletedException.class)
	public ResponseEntity<?> handdleBookDeleted(BookDeletedException ex){
		return ResponseEntity
				.status(410)
				.body(ex.getMessage());
	}
	
}
