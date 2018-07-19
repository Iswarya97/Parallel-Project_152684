package com.capgemini.test;

import com.capgemini.bean.Account;

import junit.framework.TestCase;

public class AccountTest extends TestCase {

	Account a = new Account();

	public void testGetAccountNumber() {
		assertEquals("1234", "valid");
		assertEquals("acvjg", "Invalid");
		a.setAccountNumber(1001);
		assertEquals(1001, a.getAccountNumber());
		assertNotSame(1, a.getAccountNumber());

	}

	public void testGetBalance() {
		assertEquals("abv", "Invalid");
		assertEquals("1.iu89", "Invalid");
		assertEquals("10000", "valid");
		a.setBalance(1000);
		assertEquals(1, a.getBalance());
		assertNotSame(1, a.getBalance());
	}

}
