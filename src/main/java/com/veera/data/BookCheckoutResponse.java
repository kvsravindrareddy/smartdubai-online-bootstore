package com.veera.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class BookCheckoutResponse {
	public BookCheckoutResponse(String name, String description, String author, String bookType, double price,
			String isbn, String promoCode) {
		this.name = name;
		this.description = description;
		this.author = author;
		this.bookType = bookType;
		this.price = price;
		this.isbn = isbn;
		this.promoCode = promoCode;
	}

	private String name;
	private String description;
	private String author;
	private String bookType;
	private double price;
	private String isbn;// International Standard Book Number
	private String promoCode;
}