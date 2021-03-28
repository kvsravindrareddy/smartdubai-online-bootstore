package com.veera.data;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BooksCheckoutResponse {
	private List<BookCheckoutResponse> booksDetails;
	private double maxDiscountedPrice;
	private double totalPriceBeforeDiscount;
	private double totalPriceAfterDiscount;
}