package com.service;

import java.util.List;

import com.dto.CreditCard;

public interface CreditCardService {
	List<CreditCard> getCreditCardId(int id);
	int updateCreditCard(int id);
	int deleteCreditCard(int id);
	int addCreditCard(CreditCard a);
}
