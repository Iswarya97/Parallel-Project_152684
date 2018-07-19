package com.capgemini.service;

public class PaymentWalletValidate {
	

	public boolean validatephoneNumber(String phoneNumber) {
		// TODO Auto-generated method stub
		if(phoneNumber.length()==10)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public boolean validateuserName(String userName)
	{if(userName.equals("[a-zA-Z]+\\.?")) {
		return true;
		
	}
	return false;
}
	public boolean validatepassword(String password)
	{
	if(password.length()>5)
	{
		return true;
		
	}
return false;
	}
	public boolean validateemail(String email) {
		if(email.contains("@") && email.contains("com"))
		{
			return true;
		}
		else {
	return false;
	}
	}

	public boolean validateage(int age) {
		// TODO Auto-generated method stub
		if(age>15) {
			return true;
		}
		return false;
	}
	

}
