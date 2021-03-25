package com.veera.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.veera.data.BookData;
import com.veera.entity.BookEntity;
import com.veera.service.OnlineBookStoreService;

/**
 * Rest Controller to expose the API's for the Online Book Store.
 * 
 * @author Veera.Shankara
 *
 */
@RestController
@RequestMapping("/online")
@CrossOrigin(origins = "*")
public class OnlineBookStoreController {

	@Autowired
	private OnlineBookStoreService onlineBookStoreService;

	@GetMapping("/test")
	public String hello() {
		return "hello";
	}

	@PostMapping("/addbook")
	public BookEntity addBook(@RequestBody BookEntity bookData) {
		return onlineBookStoreService.addBook(bookData);
	}

	@GetMapping("/showbooks")
	public List<BookEntity> showAllBooksFromStore() {
		return onlineBookStoreService.findAllBooksFromStore();
	}

	@DeleteMapping("/deletebook")
	public void deleteBookByIsbn(@RequestParam("isbn") String isbn) {
		onlineBookStoreService.deleteBookByIsbn(isbn);
	}

	@PutMapping("/updatebookdetails")
	public BookEntity updateBookDetailsByIsbn(@RequestBody BookEntity bookData) {
		return onlineBookStoreService.updateBookDetailsByIsbn(bookData);
	}

	@GetMapping("/checkoutbooks")
	public List<BookData> checkoutBooks(@RequestParam("isbns") List<String> isbns,
			@RequestParam("promoCode") String promoCode) {
		return onlineBookStoreService.checkoutBooks(isbns, promoCode);
	}
}