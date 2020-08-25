package com.dxctraining.suppliermgt.supplier.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CentralizedExceptionHandler {
	
	@ExceptionHandler(SupplierNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handleSupplierNotFound(SupplierNotFoundException e) {
		String msg = e.getMessage();
		return msg;
	}
	
	@ExceptionHandler(InvalidArgumentException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public String handleInvalidSupplier(InvalidArgumentException e) {
		String msg = e.getMessage();
		return msg;
	}

}