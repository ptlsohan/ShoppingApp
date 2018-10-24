package com.repository;

import java.util.List;

import com.dto.CreditCard;

public interface CreditCardRepository {
	List<CreditCard> getCreditCardId(int id);
	int updateCreditCard(int id);
	int deleteCreditCard(int id);
	int addCreditCard(CreditCard a);
}
