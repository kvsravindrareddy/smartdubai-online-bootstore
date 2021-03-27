package com.veera.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class BookCheckoutResponse {
	private String name;
	private String description;
	private String author;
	private String bookType;
	private double originalPrice;
	private double discountedPrice;
	private String isbn;//International Standard Book Number
	private String promoCode;
}