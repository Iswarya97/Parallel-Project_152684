package com.capgemini.dao;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.capgemini.bean.Account;
import com.capgemini.bean.Customer;

	public class PaymentWalletDao implements IPaymentWalletDao {
	
		static HashMap<String, Account> map1 = new HashMap<String, Account>();

		
		static List<String> trans =new ArrayList<String>();
		 static Account acc1;

		public boolean loginAccount(String userName, String password) {
			
			
			for(String key : map1.keySet())
			{
				
				acc1=map1.get(key);
				if(acc1.getCus().getUserName().equals(userName) && acc1.getCus().getPassword().equals(password))
				{
					System.out.println(map1);
					return true;
				}
			}
			return false;
			
		}
		public boolean addCustomerDetails(Account account) {
			
			
			map1.put(account.getCus().getUserName(), account);
			
			System.out.println(map1);
			
			
			return true;
		}
		

		public float showBalance() {
		
			return acc1.getBalance();
		}

		public boolean depositAmount(float amount) {
			
	        acc1.setBalance(acc1.getBalance()+amount);
	        System.out.println(acc1.getBalance());
			System.out.println(map1);
			String dep = "The amount" +amount+"deposited successfully";
			trans.add(dep);
			return true;
		}

		public boolean withdrawAmount(float amount) {
		
			if(acc1.getBalance() >= (amount+300))
			{
				acc1.setBalance(acc1.getBalance()-amount);
				return true;
			}
			else
			{
				System.out.println("Minimum balance should be maintained");
			}
			return false;
		}

		public boolean fundTransfer(int accountNumber, float amount) {
			
			for(String key : map1.keySet())
			{
				
				Account ac1 = map1.get(key);
				if(ac1.getAccountNumber()==accountNumber)
				{
					ac1.setBalance(ac1.getBalance()+amount);
					System.out.println(ac1);
					acc1.setBalance(acc1.getBalance()-amount);
					System.out.println(acc1);
					return true;
				}
				else
				{
					System.out.println("No Id generated");
				}
			}
			return false;
		}

		public void printTransaction() {
			
			System.out.println(trans);

		
		}


	
	}

