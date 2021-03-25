package com.veera.data;

import lombok.Getter;
import lombok.Setter;

/**
 * Data class for Online Book Store Data
 * @author Veera.Shankara
 *
 */
@Setter
@Getter
public class BookData {
	private String name;
	private String description;
	private String author;
	private String bookType;
	private double price;
	private String isbn;//International Standard Book Number
}