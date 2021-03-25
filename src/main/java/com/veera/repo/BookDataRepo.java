package com.veera.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

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
}