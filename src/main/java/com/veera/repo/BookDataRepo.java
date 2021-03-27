package com.veera.repo;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.veera.data.BookCheckoutResponse;
import com.veera.entity.BookEntity;

/**
 * Repository to persist the online book store into DB
 * @author Veera.Shankara
 *
 */
@Repository
public interface BookDataRepo extends CrudRepository<BookEntity, Long>{
	void deleteByIsbn(String isbn);
	Optional<BookEntity> findByIsbn(String isbn);
	 
	@Query(value = "delete from book_data_tb where isbn in (:isbns)", nativeQuery = true)
	@Transactional
	@Modifying
	void deleteSelectedBooks(@Param("isbns") String[] isbns);
	
	@Query("SELECT new com.veera.data.BookCheckoutResponse(bdt.name, bdt.description, bdt.author,bdt.booktype,bdt.originalprice,bdt.discountedprice, bdt.isbn, bpt.promoCode"
			+ ") FROM BOOK_DATA_TB bdt, BOOK_PROMO_TB bpt")
	List<BookCheckoutResponse> bookCheckoutResponse();
}