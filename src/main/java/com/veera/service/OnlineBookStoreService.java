package com.veera.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.veera.data.BookData;
import com.veera.entity.BookEntity;
import com.veera.repo.BookDataRepo;

/**
 * Online Book store to handle the business logic
 * @author Veera.Shankara
 *
 */
@Service
public class OnlineBookStoreService {

	@Autowired
	private BookDataRepo bookDataRepo;
	
	@Autowired
	private Gson gson;

	/**
	 * Add new Book to book store database
	 * 
	 * @param bookData
	 * @return BookData
	 */
	public BookEntity addBook(BookEntity bookData) {
		return bookDataRepo.save(bookData);
	}

	/**
	 * Find All books from bookstore database
	 * 
	 * @return List<BookData>
	 */
	public List<BookEntity> findAllBooksFromStore() {
		Iterable<BookEntity> itrb = bookDataRepo.findAll();
		return StreamSupport.stream(itrb.spliterator(), false).collect(Collectors.toList());
	}

	/**
	 * Delete book by isbn
	 * @param isbn
	 */
	public void deleteBookByIsbn(String isbn) {
		bookDataRepo.deleteByIsbn(isbn);
	}

	/**
	 * Update book details by isbn
	 * @param isbn
	 * @param bookData
	 * @return
	 */
	public BookData updateBookDetailsByIsbn(BookData bookData) {
		BookData resBookDataResult = null;
		Optional<BookEntity> respBookEntity = bookDataRepo.findByIsbn(bookData.getIsbn());
		if(respBookEntity.isPresent())
		{
			BookEntity be = respBookEntity.get();
			be.setId(be.getId());
			be.setAuthor(bookData.getAuthor());
			be.setBookType(bookData.getBookType());
			be.setDescription(bookData.getDescription());
			be.setIsbn(bookData.getIsbn());
			be.setPrice(bookData.getPrice());
			be.setName(bookData.getName());
			BookEntity beResult = bookDataRepo.save(be);
			String json = gson.toJson(beResult);
			resBookDataResult = gson.fromJson(json, BookData.class);
		}
		return resBookDataResult;
	}

	/**
	 * Checkout books and optionally user can enter the promo code
	 * @param isbns
	 * @param promoCode
	 * @return
	 */
	public List<BookData> checkoutBooks(List<String> isbns, String promoCode) {
		return null;
	}

	/**
	 * User can check the book price by entering the isbn value
	 * @param isbn
	 * @return
	 */
	public BookData showBookPrice(String isbn) {
		Optional<BookEntity> bookEntity = bookDataRepo.findByIsbn(isbn);
		BookData bookDataResponse = null;
		if(bookEntity.isPresent())
		{
			String json = gson.toJson(bookEntity.get());
			bookDataResponse = gson.fromJson(json, BookData.class);
		}
		return bookDataResponse;
	}

	/**
	 * Admin can remove all the books from DB
	 */
	@Transactional
	public void deleteAllBooks() {
		bookDataRepo.deleteAll();
	}

	/**
	 * Admin can delete only the selected books
	 * @param isbns
	 */
	public void deleteSelectedBooks(String[] isbns) {
		bookDataRepo.deleteSelectedBooks(isbns);
	}

}