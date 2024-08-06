package com.sri.serversidevalidation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.sri.model.Customer;
@Component
public class FormValidation implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(Customer.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Customer cust=(Customer)target;
		
		if(cust.getPassword().length()<5) {
			errors.rejectValue("password", "customer.name");
		}

	}

	
}
