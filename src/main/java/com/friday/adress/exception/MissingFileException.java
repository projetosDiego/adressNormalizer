package com.friday.adress.exception;

public class MissingFileException extends RuntimeException{

	private static final long serialVersionUID = 7465743800857659454L;

	public MissingFileException(String message) {
		super(message);
	}

}
