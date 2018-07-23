package com.capg.Payment.Test;

import com.capg.PaymentWallet.bean.Customer;

import junit.framework.TestCase;

public class CustomerTest extends TestCase {
Customer c= new Customer();
	public void testGetName() {
		assertEquals("ishu", "Iswarya");
		assertEquals("akalya", "valid");
		assertEquals("134", "invalid");
	}

	public void testGetPhoneNumber() {

		assertEquals(0, c.getPhoneNumber());
		assertEquals("1234455433", "9785634673");
	}

	public void testGetEmail() {
		c.setEmail("k@k.com");
		assertEquals("k@k.com", c.getEmail());
		assertEquals("kkk", c.getEmail());
	}

	public void testGetAge() {
		c.setAge(22);
		assertEquals(22, c.getAge());
		assertEquals(21, c.getAge());
	}

	public void testGetGender() {
		c.setGender("male");
		assertEquals("male", c.getGender());
	}

	public void testGetUserName() {
		c.setPassword("user");
		assertNotSame("123", c.getPassword());
	}

	public void testGetPassword() {
		c.setPassword("1234");
		assertNotSame("k@k.com", c.getPassword());
	
	}

}
