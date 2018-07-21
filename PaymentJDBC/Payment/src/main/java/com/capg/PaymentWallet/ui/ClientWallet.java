package com.capg.PaymentWallet.ui;

import java.util.Scanner;

import com.capg.PaymentWallet.bean.Account;
import com.capg.PaymentWallet.bean.Customer;
import com.capg.PaymentWallet.service.PaymentWalletService;
import com.capg.PaymentWallet.service.PaymentWalletValidate;

public class ClientWallet {
	static boolean b;

		public static void main(String[] args) {
			int choice = 0;
			float amount;
			PaymentWalletService service = new PaymentWalletService();
			PaymentWalletValidate validate = new PaymentWalletValidate();
			Account account = new Account();


			do {
				int choice1;
				Scanner scan = new Scanner(System.in);
				System.out.println("***********WELCOME TO BANKING WORLD*********");
				System.out.println("**********     HAPPY BANKING  ***************");
				System.out.println("1.Create an account");
				System.out.println("2.If existing user PLEASE LOGIN");
				System.out.println("*********************************************");

				
				choice= scan.nextInt();
				switch(choice)
				{
				case 1:
					
					Customer wallet = new Customer();
					
					Scanner sc = new Scanner(System.in);
					
					System.out.println("Enter your UserName: ");
					String userName = sc.nextLine();
					
					System.out.println("Enter your Password: ");
					String password = sc.nextLine();
					
					System.out.println("Enter Customer Name: ");
					String name = sc.nextLine();
					
					System.out.println("Enter Customer Age: ");
					int age = sc.nextInt();
					sc.nextLine();
					
					System.out.println("Enter Customer gender: ");
					String gender = sc.nextLine();
					
					System.out.println("Enter Customer Mobile Number: ");
					String phoneNumber = sc.nextLine();
					
					
					System.out.println("Enter Customer EmailID");
					String email = sc.nextLine();
					
					
					
					System.out.println("Enter initial balance: ");
					float balance = sc.nextFloat();
					
					int accountNumber = (int)(Math.random() * 123456+123456);
					boolean isValidage=validate.validateage(age);
					boolean isValidpassword=validate.validatepassword(password);
					boolean isValiduserName=validate.validateuserName(userName);
					boolean isValidphoneNumber = validate.validatephoneNumber(phoneNumber);
					boolean isValidemail = validate.validateemail(email);
					
					
					if(  isValidphoneNumber && isValidemail )
					{
						wallet.setUserName(userName);
						wallet.setPassword(password);
					
						wallet.setName(name);
						wallet.setAge(age);
						wallet.setGender(gender);
						account.setBalance(balance);
						wallet.setEmail(email);
						wallet.setPhoneNumber(phoneNumber);
						account.setAccountNumber(accountNumber);
						account.setCus(wallet);
						
						b= service.addCustomerDetails(account);
						if(b)
						{
							
							System.out.println("Account Created Successfully ");
							System.out.println("The Account Number is"+accountNumber);
							System.out.println("Your UserName is: "+userName);
							System.out.println("Your Password is :"+password);
						}
					
					else
					{
						System.out.println("Enter Phone number correctly in 10 digits");
						System.out.println("Initial balance should be 300");


					}
					}
					
					break;
					
				case 2:
					
					Scanner s = new Scanner(System.in);
					System.out.println("Enter Your Username");
					userName = s.nextLine();
					System.out.println("Enter Your Password");
					password = s.nextLine();
					
					b= service.loginAccount(userName, password);
					if(b)
					{
						System.out.println("Successful");
					} else {
					
					  System.out.println("OOPS!!!!!!....INVALID USER");
					}
					
					if(b)
				
					{
						do {
							
							System.out.println("***************WELCOME**********************");
							System.out.println("1.Deposit Amount");
							System.out.println("2.Withdraw Amount");
							System.out.println("3.Show Balance");
							System.out.println("4.Fund Transfer");
							System.out.println("5.Print Transactions");
							System.out.println("6.Exit");
							System.out.println("*********************************************");

							
							System.out.println("\nWELCOME......\n Enter Your Choice");
							
							choice1 = scan.nextInt(); 
							
							switch(choice1)
							{
							
							
								
							case 1:
								
								Scanner sc1 = new Scanner(System.in);
								
								System.out.println("Enter amount to deposit");
								amount = sc1.nextFloat();
								boolean isDeposit = service.depositAmount(amount);
								
								if(isDeposit)
								{
									System.out.println("AMOUNT DEPOSITED");
								}
								break;
								
							case 2 : 
								
								Scanner sc2 = new Scanner(System.in);

								System.out.println("Enter amount to withdraw");
								amount = sc2.nextFloat();
								boolean isWithdraw = service.withdrawAmount(amount);
								
								if(isWithdraw)
								{
									System.out.println("AMOUNT WITHDRAWN");
								}
								break;
								
							case 3 : 
								
								     balance = service.showBalance();
									System.out.println("Account Balance is: "+balance);
								break;
								
							case 4:
								
								Scanner scan2 = new Scanner(System.in);
								
								
								System.out.println(" Enter Account Number to transfer amount");
								int accountNumber2 = s.nextInt();
								System.out.println("Enter Amount to Transfer");
								amount = scan2.nextFloat();
								boolean b1= service.fundTransfer(accountNumber2, amount);
								if(b1)
								{
									System.out.println("FUND TRANSFERED SUCCESSFULLY");
								}
								else
								{
									System.out.println("INVALID INPUT");
								}
								break;
								
							case 5:
								
								service.printTransaction();
								break;
								
							case 6 : System.exit(0);
								
								break;
							
							
							}
						
						}while(choice1!=7);
						
						
					}
					
					else
					{
						System.out.println("OOPS!!!! LOGIN DETAILS INVALID....");
					}
				break;
				
				
				}
			}while(choice!=3);
		}
}