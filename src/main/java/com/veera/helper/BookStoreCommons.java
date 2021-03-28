package com.veera.helper;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Add all common methods here
 * @author Veera.Shankara
 *
 */
public class BookStoreCommons {

	/**
	 * Get current date
	 * @return
	 */
	public static Date currentDate() {
		return new Date();
	}

	/**
	 * Get Discount percentage value from promo code
	 * @param promoCode
	 * @return
	 */
	public static int numberFromString(String promoCode) {
		Pattern lastIntPattern = Pattern.compile("[^0-9]+([0-9]+)$");
		int lastNumberInt = 0;
		Matcher matcher = lastIntPattern.matcher(promoCode);
		if (matcher.find()) {
			String someNumberStr = matcher.group(1);
			lastNumberInt = Integer.parseInt(someNumberStr);
		}
		return lastNumberInt;
	}
	
//	public static void main(String[] args) {
//		System.out.println(numberFromString("DIS10"));
//	}
}