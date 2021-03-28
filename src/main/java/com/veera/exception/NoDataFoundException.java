package com.veera.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class NoDataFoundException extends RuntimeException {
	private static final long serialVersionUID = 9169686304873689552L;
	private String msg;
}