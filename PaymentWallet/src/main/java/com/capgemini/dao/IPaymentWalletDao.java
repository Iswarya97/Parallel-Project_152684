package com.capgemini.dao;

import com.capgemini.bean.Account;
import com.capgemini.bean.Customer;

public interface IPaymentWalletDao {
	public boolean loginAccount(String userName,String password);
    public boolean addCustomerDetails(Account account);
	public float showBalance();
	public boolean depositAmount(float amount);
	public boolean withdrawAmount(float amount);
	public boolean fundTransfer(int accountNumber,float amount);
	public void printTransaction();

}
