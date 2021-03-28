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
 * 
 * @author Veera.Shankara
 *
 */
@Repository
public interface BookDataRepo extends CrudRepository<BookEntity, Long> {
	void deleteByIsbn(String isbn);

	Optional<BookEntity> findByIsbn(String isbn);

	@Query(value = "delete from book_data_tb where isbn in (:isbns)", nativeQuery = true)
	@Transactional
	@Modifying
	void deleteSelectedBooks(@Param("isbns") String[] isbns);

//	select bdt.author, bdt.book_type, bdt.description , bdt.isbn, bdt.name, bdt.price, bpt.promo_code, bpt.validity_date
//	from book_data_tb bdt, book_promo_tb bpt 
//	where bdt.book_type=bpt.book_type
//	and bdt.isbn in ('string','string1')
//	and (bpt.promo_code is null or bpt.promo_code = 'string');

	@Query("SELECT new com.veera.data.BookCheckoutResponse(bdt.name, bdt.description, bdt.author,bdt.bookType, bdt.price, bdt.isbn, bpt.promoCode"
			+ ") FROM BookEntity bdt, PromoEntity bpt where bdt.bookType=bpt.bookType and bdt.isbn in (:isbns) and (bpt.promoCode is null or bpt.promoCode=:promoCode)")
	List<BookCheckoutResponse> bookCheckoutResponse(@Param("isbns") String[] isbns,
			@Param("promoCode") String promoCode);
}