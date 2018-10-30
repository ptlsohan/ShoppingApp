package com.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.dto.User;

public class CustomPassword implements
ConstraintValidator<ConfirmPassword, User>{

	@Override
	public boolean isValid(User value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		System.out.println("c pass"+value.getConfirmPassword());
		System.out.println(" pass"+value.getPassword());
		return value.getPassword().equals(value.getConfirmPassword());
	}
	

}
