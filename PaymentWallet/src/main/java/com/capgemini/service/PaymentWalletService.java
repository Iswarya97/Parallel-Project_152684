package com.capgemini.service;

import com.capgemini.bean.Account;
import com.capgemini.bean.Customer;
import com.capgemini.dao.PaymentWalletDao;
public class PaymentWalletService implements IPaymentWalletService {

	PaymentWalletDao dao= new PaymentWalletDao();
	public boolean loginAccount(String userName, String password) {
		// TODO Auto-generated method stub
		return dao.loginAccount(userName, password);
	}

	public boolean addCustomerDetails(Account account) {
		// TODO Auto-generated method stub
		return dao.addCustomerDetails(account);
	}

	public float showBalance() {
		// TODO Auto-generated method stub
		return dao.showBalance();
	}

	public boolean depositAmount(float amount) {
		// TODO Auto-generated method stub
		return dao.depositAmount(amount);
	}

	public boolean withdrawAmount(float amount) {
		// TODO Auto-generated method stub
		return dao.withdrawAmount(amount);
	}

	public boolean fundTransfer(int accountNumber, float amount) {
		// TODO Auto-generated method stub
		return dao.fundTransfer(accountNumber,amount);
	}

	public void printTransaction() {
		// TODO Auto-generated method stub
		dao.printTransaction();
		
	}

	
}

