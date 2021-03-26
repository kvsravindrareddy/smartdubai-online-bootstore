package com.veera.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Custom runtime exception to handle the invalid input
 * @author Veera.Shankara
 *
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class InvalidInputException extends RuntimeException {
	private static final long serialVersionUID = 367944720162075970L;
	private String msg;
}