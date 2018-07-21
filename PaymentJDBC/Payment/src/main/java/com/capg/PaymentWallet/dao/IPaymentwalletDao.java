package com.capg.PaymentWallet.dao;

import com.capg.PaymentWallet.bean.Account;

public interface IPaymentwalletDao {
	public boolean loginAccount(String userName,String password);
    public boolean addCustomerDetails(Account account);
	public float showBalance();
	public boolean depositAmount(float amount);
	public boolean withdrawAmount(float amount);
	public boolean fundTransfer(int accountNumber2, float amount);
	public void printTransaction();

	
}