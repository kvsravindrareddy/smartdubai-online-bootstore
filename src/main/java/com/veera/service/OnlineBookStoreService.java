package com.veera.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public BookEntity updateBookDetailsByIsbn(BookEntity bookData) {
		BookEntity resBookData = null;
		if(bookDataRepo.findByIsbn(bookData.getIsbn()).isPresent())
		{
			resBookData = bookDataRepo.save(bookData);
		}
		return resBookData;
	}

	public List<BookData> checkoutBooks(List<String> isbns, String promoCode) {
		return null;
	}

}
