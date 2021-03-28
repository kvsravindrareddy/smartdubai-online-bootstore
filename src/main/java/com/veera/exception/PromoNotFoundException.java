package com.veera.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * If the promo code is not found in database throw exception
 * @author Veera.Shankara
 *
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PromoNotFoundException extends RuntimeException {
	private static final long serialVersionUID = -5869737104866001431L;
	private String msg;
}
