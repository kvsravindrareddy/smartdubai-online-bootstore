package com.veera.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.veera.entity.PromoEntity;

public interface PromoRepo extends CrudRepository<PromoEntity, Long> {
	Optional<PromoEntity> findByPromoCode(String promoCode);
	void deleteByPromoCode(String promoCode);
}