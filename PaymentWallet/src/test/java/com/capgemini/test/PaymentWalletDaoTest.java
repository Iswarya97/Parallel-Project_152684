package com.capgemini.test;

import junit.framework.TestCase;

public class PaymentWalletDaoTest extends TestCase {

	public void testLoginAccount() {
		assertEquals("result", 0, 0);
	}

	public void testAddCustomerDetails() {

		assertEquals("Invalid Account", 100, 0);
		assertFalse("Invalid Number", false);
		assertEquals(1452398, 123456);
	}

	public void testShowBalance() {
		assertEquals("result", 0, 0);
		assertNotSame("10300", "13500");

	}

	public void testDepositAmount() {

		assertEquals(1000, 1500);
		assertFalse(false);
		assertEquals("Invalid Id.Cannot deposit", 2500, 1500);
	}

	public void testWithdrawAmount() {
		assertEquals(2500, 1000);
		assertFalse("Aishu", false);
		assertEquals("Invalid withdrawal", 5000, 2500);

	}

	public void testFundTransfer() {
		assertEquals("Transfer successful", "Good job");
		assertEquals(2000, 1000);
		assertEquals(null, 0, 0);
	}

	public void testPrintTransaction() {
		assertEquals("Invalid Transaction", "Try Again");
		assertEquals("Valid Transaction", "Good Job");
		assertNotSame("Print", "Valid");
	}

}
