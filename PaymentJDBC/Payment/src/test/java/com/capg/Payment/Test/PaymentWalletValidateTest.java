package com.capg.Payment.Test;

import com.capg.PaymentWallet.service.PaymentWalletValidate;

import junit.framework.TestCase;

public class PaymentWalletValidateTest extends TestCase {
PaymentWalletValidate validate= new PaymentWalletValidate();
	public void testValidatephoneNumber() {
		assertEquals(true, validate.validatephoneNumber("9988776654"));
		assertFalse(validate.validatephoneNumber("9333"));
		assertTrue(validate.validatephoneNumber("7894561236"));
		assertNotNull(validate.validatephoneNumber("9222415172"));
	}

	public void testValidateuserName() {
		assertNotNull(validate.validateuserName("capge"));
		assertTrue(validate.validateuserName("customer1"));
	}

	public void testValidatepassword() {
		assertEquals("ishu123", "valid");
		assertEquals("25634", "invalid");
	}

	public void testValidateemail() {
		assertEquals(true, validate.validateemail("google@gmail.com"));
		assertNotNull(validate.validateemail("google@gmail.com"));
		assertTrue(validate.validateemail("goo@gmail.com"));
	}

	public void testValidateage() {
		assertEquals(true, validate.validateage(11));
		assertNotSame(false, validate.validateage(12));
	}

}
