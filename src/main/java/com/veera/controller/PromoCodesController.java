package com.veera.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.veera.data.PromoData;
import com.veera.service.PromoCodeService;

/**
 * PromoCode controller to add, update and delete promo codes
 * @author Veera.Shankara
 *
 */
@RestController
@RequestMapping("/promo")
public class PromoCodesController {
	
	@Autowired
	private PromoCodeService promoCodeService;
	
	@PostMapping("/addpromo")
	public void addPromoCode(@RequestBody PromoData promoData)
	{
		promoCodeService.addPromoCode(promoData);
	}
	
	@GetMapping("/promocodes")
	public List<PromoData> listAllPromoCodes()
	{
		return promoCodeService.listAllPromoCodes();
	}
	
	@DeleteMapping("/deletepromo")
	public void deletePromoCode(@RequestParam("promoCode") String promoCode)
	{
		promoCodeService.deletePromoCode(promoCode);
	}
	
	@GetMapping("/getpromocode")
	public PromoData getPromoCodeData(@RequestParam("promoCode") String promoCode)
	{
		return promoCodeService.getPromoCodeData(promoCode);
	}
	
	@PutMapping("/updatepromocode")
	public PromoData updatePromoCode(@RequestBody PromoData promoData)
	{
		return promoCodeService.updatePromoCode(promoData);
	}
}