package com.veera.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.veera.common.JsonDateDeserializer;
import com.veera.data.PromoData;
import com.veera.entity.PromoEntity;
import com.veera.repo.PromoRepo;

@Service
public class PromoCodeService {

	@Autowired
	private PromoRepo promoRepo;
	
	@Autowired
	private Gson gson;
	
	public void addPromoCode(PromoData promoData) {
		System.out.println("............."+promoData.getValidityDate());
		String promoJson = gson.toJson(promoData);
		PromoEntity promoEntity = gson.fromJson(promoJson, PromoEntity.class);
		promoRepo.save(promoEntity);
	}

	public List<PromoData> listAllPromoCodes() {
		Iterable<PromoEntity> itrb = promoRepo.findAll();
		List<PromoEntity> promoEntities = StreamSupport.stream(itrb.spliterator(), false).collect(Collectors.toList());
		String promosJson = gson.toJson(promoEntities);
		System.out.println("........json......."+promosJson);
		Gson gsonDate = new GsonBuilder().registerTypeAdapter(Date.class, new JsonDateDeserializer()).create();;
		System.out.println(".........."+gson);
		return gsonDate.fromJson(promosJson, new TypeToken<List<PromoData>>(){}.getType());
	}
}