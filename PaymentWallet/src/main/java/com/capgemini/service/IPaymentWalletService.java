package com.capgemini.service;

import com.capgemini.bean.Account;
import com.capgemini.bean.Customer;

public interface IPaymentWalletService {
	public boolean loginAccount(String userName,String password);
    public boolean addCustomerDetails(Account account);
	public float showBalance();
	public boolean depositAmount(float amount);
	public boolean withdrawAmount(float amount);
	public boolean fundTransfer(int accountNumber,float amount);
	public void printTransaction();

}
