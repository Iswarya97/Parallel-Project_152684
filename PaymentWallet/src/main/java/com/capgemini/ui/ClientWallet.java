package com.capgemini.ui;

import java.util.Scanner;

import com.capgemini.bean.Account;
import com.capgemini.bean.Customer;
import com.capgemini.service.PaymentWalletService;
import com.capgemini.service.PaymentWalletValidate;

public class ClientWallet {
	static boolean a;
	static boolean b;

	public static void main(String[] args) {
		int choice = 0;
		int amount = 0;
		

		do {
			int choice1;
			Scanner scan = new Scanner(System.in);
			System.out.println("*****************************************");
			System.out.println("WELCOME TO BANKING WORLD");
			System.out.println("1.Create an account");
			System.out.println("2.If  already existing user PLEASE LOGIN");
			System.out.println("*****************************************");

			choice = scan.nextInt();
			switch (choice) {
			case 1:
				Customer wallet = new Customer();
				PaymentWalletService service = new PaymentWalletService();
				PaymentWalletValidate validate = new PaymentWalletValidate();
				Account account = new Account();
				Scanner sc = new Scanner(System.in);

				System.out.println("Enter your UserName ");
				String userName = sc.nextLine();

				System.out.println("Enter your Password");
				String password = sc.nextLine();

				System.out.println("Enter Customer Name");
				String name = sc.nextLine();

				System.out.println("Enter Customer Age");
				int age = sc.nextInt();
				sc.nextLine();

				System.out.println("Enter Customer gender");
				String gender = sc.nextLine();

				System.out.println("Enter Customer Mobile Number");
				String phoneNumber = sc.nextLine();

				System.out.println("Enter Customer EmailID");
				String email = sc.nextLine();

				int accountNumber = (int) (Math.random() * 123456 + 123456);

				boolean isValidphoneNumber = validate.validatephoneNumber(phoneNumber);
				boolean isValidemail = validate.validateemail(email);
				boolean isValidage = validate.validateage(age);
				
					wallet.setUserName(userName);
					wallet.setPassword(password);
					wallet.setName(name);
					wallet.setAge(age);
					wallet.setGender(gender);
					wallet.setEmail(email);
					wallet.setPhoneNumber(phoneNumber);
					account.setAccountNumber(accountNumber);
					wallet.setAmount(amount);
                     account.setCus(wallet);
                     if (isValidphoneNumber&& isValidemail && isValidage) {
					a = service.addCustomerDetails(account);
                     }
                     else
                     {
                    	 System.out.println("invalid");
                     }
					if (a) {

						System.out.println("ACCOUNT CREATED SUCCESSFULLY... Account No is: " + accountNumber);
						System.out.println("UserName is: " + userName);
						System.out.println("Password is :" + password);

					}
					else 
					{
						System.out.println("Account Not Created");
					}
				break;

				

			case 2:
				PaymentWalletService service1 = new PaymentWalletService();
				Scanner s = new Scanner(System.in);
				System.out.println("Enter Your Username");
				userName = s.nextLine();
				System.out.println("Enter Your Password");
				password = s.nextLine();

				b = service1.loginAccount(userName, password);
				

			if(b) {	
				
					System.out.println("LOGIN SUCCESS");
			}
			else
			{
				System.out.println("Invalid Details");
			}
			if (b)
			{
				do {
						System.out.println("*******************************");
						System.out.println("1.Deposit Amount");
						System.out.println("2.Withdraw Amount");
						System.out.println("3.Show Balance");
						System.out.println("4.Fund Transfer");
						System.out.println("5.Print Transactions");
						System.out.println("6.Exit");
						System.out.println("********************************");

						System.out.println("\nWELCOME......\nEnter Your Choice");

						choice1 = scan.nextInt();

						switch (choice1) {

						case 1:
							PaymentWalletService service2 = new PaymentWalletService();
							Scanner sc1 = new Scanner(System.in);

							System.out.println("Enter amount to deposit");
							amount = sc1.nextInt();
							boolean isDeposit = service2.depositAmount(amount);

							if (isDeposit) {
								System.out.println("AMOUNT DEPOSITED SUCCESSFULLY");
							}
							break;

						case 2:
							PaymentWalletService service3 = new PaymentWalletService();
							Scanner sc2 = new Scanner(System.in);

							System.out.println("Enter amount to withdraw");
							amount = sc2.nextInt();
							boolean isWithdraw = service3.withdrawAmount(amount);

							if (isWithdraw) {
								System.out.println("SUCCESSFULL AMOUNT WITHDRAWAL");
							}
							break;

						case 3:
							PaymentWalletService service4= new PaymentWalletService();
							float balance = service4.showBalance();
							balance= service4.showBalance();
							System.out.println("Account Balance is: " + balance);
							break;

						case 4:
							
							Scanner scn = new Scanner(System.in);
							System.out.println(" Enter Account Number to transfer amount");
							accountNumber = s.nextInt();
							
							
							System.out.println("Enter Amount to Transfer");
							amount = scn.nextInt();
							scn.nextLine();
							PaymentWalletService service5 = new PaymentWalletService();
							System.out.println("Fund transfer");
							boolean b1 = service5.fundTransfer(accountNumber, amount);
							if (b1) {
								System.out.println("FUND TRANSFERED SUCCESSFULLY");
							} else {
								System.out.println("Enter Correct Input");
							}
							break;

						case 5:
							PaymentWalletService service6 = new PaymentWalletService();
							service6.printTransaction();
							break;

						case 6:
							

							break;

						}

					} while (choice1 != 6);

			}
			else
			{
				System.out.println("invalid");
			}
				
			break;
			}
				
		} while (choice != 3);
	}
}
