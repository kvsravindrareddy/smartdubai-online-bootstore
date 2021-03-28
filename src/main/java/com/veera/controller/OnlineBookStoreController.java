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
import com.veera.data.BooksCheckoutResponse;
import com.veera.entity.BookEntity;
import com.veera.service.OnlineBookStoreService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Rest Controller to expose the API's for the Online Book Store.
 * 
 * @author Veera.Shankara
 *
 */
@RestController
@RequestMapping("/online")
@CrossOrigin(origins = "*")
@Api(value = "Online Book Store")
public class OnlineBookStoreController {

	@Autowired
	private OnlineBookStoreService onlineBookStoreService;

	@PostMapping("/addbook")
	@ApiOperation(value = "Add New Book")
	public BookEntity addBook(@RequestBody BookEntity bookData) {
		return onlineBookStoreService.addBook(bookData);
	}

	@GetMapping("/showbooks")
	@ApiOperation(value = "Show all books from online store")
	public List<BookEntity> showAllBooksFromStore() {
		return onlineBookStoreService.findAllBooksFromStore();
	}

	@DeleteMapping("/deletebook")
	@ApiOperation(value="Delete books from store")
	public void deleteBookByIsbn(@RequestParam("isbn") String isbn) {
		onlineBookStoreService.deleteBookByIsbn(isbn);
	}

	@PutMapping("/updatebookdetails")
	@ApiOperation(value="Update Book details by ISBN number")
	public BookData updateBookDetailsByIsbn(@RequestBody BookData bookData) {
		return onlineBookStoreService.updateBookDetailsByIsbn(bookData);
	}

	@GetMapping("/checkoutbooks")
	@ApiOperation(value="Checkout books from cart")
	public BooksCheckoutResponse checkoutBooks(@RequestParam("isbns[]")String[] isbns,
			@RequestParam(value="promoCode", required = false) String promoCode) {
		return onlineBookStoreService.checkoutBooks(isbns, promoCode);
	}
	
	@GetMapping("/showbookprice")
	@ApiOperation(value="Show Book Price")
	public BookData showBookPrice(@RequestParam("isbn")String isbn)
	{
		return onlineBookStoreService.showBookPrice(isbn);
	}
	
	@DeleteMapping("/deleteallbooks")
	@ApiOperation(value="Delete All Books")
	public void deleteAllBooks()
	{
		onlineBookStoreService.deleteAllBooks();
	}
	
	@DeleteMapping("/deleteselectedbooks")
	@ApiOperation(value="Delete only selected books")
	public void deleteSelectedBooks(@RequestParam("isbns[]")String[] isbns)
	{
		onlineBookStoreService.deleteSelectedBooks(isbns);
	}
}