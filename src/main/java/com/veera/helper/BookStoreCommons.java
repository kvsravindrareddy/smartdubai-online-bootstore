package com.veera.helper;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BookStoreCommons {
	
	public static String currentDate()
	{
		Date date = new Date();
		return new SimpleDateFormat("dd-MM-yyyy").format(date);
	}
}