package com.veera.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.veera.common.JsonDateDeserializer;
import com.veera.data.PromoData;
import com.veera.entity.PromoEntity;
import com.veera.helper.BookStoreCommons;
import com.veera.repo.PromoRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PromoCodeService {

	@Autowired
	private PromoRepo promoRepo;

	@Autowired
	private Gson gson;

	public void addPromoCode(PromoData promoData) {
		System.out.println("............." + promoData.getValidityDate());
		Date currentDate = BookStoreCommons.currentDate();
		if (promoData.getValidityDate().after(currentDate)) {
			String promoJson = gson.toJson(promoData);
			PromoEntity promoEntity = gson.fromJson(promoJson, PromoEntity.class);
			promoRepo.save(promoEntity);
		} else {
			log.debug(
					".........Promo Date should be greater than the current date......." + promoData.getValidityDate());
		}
	}

	public List<PromoData> listAllPromoCodes() {
		Iterable<PromoEntity> itrb = promoRepo.findAll();
		List<PromoEntity> promoEntities = StreamSupport.stream(itrb.spliterator(), false).collect(Collectors.toList());
		String promosJson = gson.toJson(promoEntities);
		System.out.println("........json......." + promosJson);
		Gson gsonDate = new GsonBuilder().registerTypeAdapter(Date.class, new JsonDateDeserializer()).create();
		;
		System.out.println(".........." + gson);
		return gsonDate.fromJson(promosJson, new TypeToken<List<PromoData>>() {
		}.getType());
	}

	@Transactional
	public void deletePromoCode(String promoCode) {
		promoRepo.deleteByPromoCode(promoCode);
	}

	public PromoData getPromoCodeData(String promoCode) {
		PromoData promoData = null;
		Optional<PromoEntity> promoEntity = promoRepo.findByPromoCode(promoCode);
		if (promoEntity.isPresent()) {
			String json = gson.toJson(promoEntity.get());
			Gson gsonDate = new GsonBuilder().registerTypeAdapter(Date.class, new JsonDateDeserializer()).create();
			;
			promoData = gsonDate.fromJson(json, PromoData.class);
		}
		return promoData;
	}

	@Transactional
	public PromoData updatePromoCode(PromoData promoData) {
		PromoData promoDataResp = null;
		Optional<PromoEntity> promoEntityOpt = promoRepo.findByPromoCode(promoData.getPromoCode());
		if (promoEntityOpt.isPresent()) {
			PromoEntity promoEntity = promoEntityOpt.get();
			PromoEntity inputObj = new PromoEntity();
			inputObj.setId(promoEntity.getId());
			inputObj.setBookType(promoEntity.getBookType());
			inputObj.setPromoCode(promoEntity.getPromoCode());
			inputObj.setValidityDate(promoData.getValidityDate());
			String json = gson.toJson(promoRepo.save(inputObj));
			Gson gsonDate = new GsonBuilder().registerTypeAdapter(Date.class, new JsonDateDeserializer()).create();
			;
			promoDataResp = gsonDate.fromJson(json, PromoData.class);
			log.debug("...........Promo code update successfully for " + promoData.getPromoCode());
		}
		return promoDataResp;
	}
}