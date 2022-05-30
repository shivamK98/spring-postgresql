package com.java.springboot.exception;

public class ProductExistException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public ProductExistException(String message) {
		super(message);
	}

	public static String ProductAlreadyExist() {
		return "Product with given name already exist";
	}
}
