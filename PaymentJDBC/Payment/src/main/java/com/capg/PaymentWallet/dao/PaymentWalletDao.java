package com.capg.PaymentWallet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.capg.PaymentWallet.bean.Account;
import com.capg.PaymentWallet.bean.Customer;

public class PaymentWalletDao implements IPaymentwalletDao {
	JdbcUtil util = new JdbcUtil();

	float balance;
	static Customer cust;
	Account acc = new Account();
	static int acn;
	String details;
	int accountNumber;

	public boolean loginAccount(String userName, String password) {
		// TODO Auto-generated method stub
		Statement st;
		Connection con = util.getConnection();
		try {
			st = con.createStatement();
			String query = "select * from customer where userName = '" + userName + "' and password = '" + password
					+ "' ";
			st.executeQuery(query);
			ResultSet rs = st.getResultSet();
			while (rs.next()) {
				userName = rs.getString("userName");
				password = rs.getString("password");
				if (userName.equals(userName) && password.equals(password)) {
					acn = rs.getInt("accountNumber");
					return true;

				}
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	public boolean addCustomerDetails(Account account) {
		// TODO Auto-generated method stub
		Connection con = util.getConnection();
		Statement st;
		try {
			st = con.createStatement();

			PreparedStatement ps = con
					.prepareStatement("insert into paymentwallet.customer values(?,?,?,?,?,?,?,?)");
			PreparedStatement ps1 = con.prepareStatement("insert into paymentwallet.account values(?,?)");
			ps1.setInt(1, account.getAccountNumber());
			ps1.setFloat(2, account.getBalance());

			ps.setString(1, account.getCus().getName());

			ps.setString(2, account.getCus().getPhoneNumber());
			ps.setString(3, account.getCus().getEmail());
			ps.setInt(4, account.getCus().getAge());
			ps.setString(5, account.getCus().getGender());
			ps.setString(6, account.getCus().getUserName());
			ps.setString(7, account.getCus().getPassword());
			ps.setInt(8, account.getAccountNumber());
			ps.execute();

			ps1.execute();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;
	}

	public float showBalance() {
		// TODO Auto-generated method stub
		accountNumber = acn;
		Connection con = util.getConnection();
		Statement st;
		try {
			st = con.createStatement();
			String query = "select * from account where accountNumber='" + accountNumber + "'";
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				balance = rs.getFloat("balance");
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return balance;
	}

	public boolean depositAmount(float amount) {

		Connection con = util.getConnection();
		try {
			String deposit = " THE AMOUNT" + amount + "IS DEPOSITED" + "\n";
			String insertq = "INSERT INTO transactions values(?,?)";
			accountNumber = acn;
			String query = "update account set balance =balance+? where accountNumber=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setFloat(1, amount);

			ps.setInt(2, accountNumber);
			ps.executeUpdate();
			PreparedStatement ps2 = con.prepareStatement(insertq);
			ps2.setInt(2, accountNumber);
			ps2.setString(1, deposit);
			ps2.execute();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;
	}

	public boolean withdrawAmount(float amount) {
		accountNumber = acn;
		String query = "select * from account where accountNumber='" + accountNumber + "'";
		Connection con = util.getConnection();
		try {
			String withdraw = " THE AMOUNT" + amount + "WITHDRAWED" + "\n";
			String insertq = "INSERT INTO transactions values(?,?)";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				balance = rs.getFloat("balance");

			}
			if (balance >= amount) {
				String query1 = "update account set balance=balance-? where accountNumber=?";

				PreparedStatement ps = con.prepareStatement(query1);
				ps.setFloat(1, amount);

				ps.setInt(2, accountNumber);
				ps.executeUpdate();
				PreparedStatement ps3 = con.prepareStatement(insertq);
				ps3.setInt(2, accountNumber);
				ps3.setString(1, withdraw);
				ps3.execute();

			} else {
				System.out.println("not updated");
			}
			con.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return false;

	}

	public boolean fundTransfer(int accountNumber2, float amount) {

		accountNumber = acn;
		Connection con = util.getConnection();
		try {
			String fdt = "THE AMOUNT\t " + amount + "\t IS TRANSFERRED TO \t" + accountNumber2;
			String insertfund = "insert into transactions value(?,?)";

			String query2 = "select * from account where accountNumber = '" + accountNumber + "'";
			Statement st1 = con.createStatement();

			ResultSet rs1 = st1.executeQuery(query2);
			while (rs1.next()) {
				balance = rs1.getFloat("balance");

				if (balance > amount) {
					String query3 = "update account set balance = balance - ? where accountNumber = ?";
					PreparedStatement ps1 = con.prepareStatement(query3);
					ps1.setFloat(1, amount);
					ps1.setInt(2, accountNumber);
					ps1.execute();

				}
			}

			String query = "select * from account where accountNumber='" + accountNumber2 + "'";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				balance = rs.getFloat("balance");
			}
			String query1 = "update account set balance = balance+? where accountNumber = ?";

			PreparedStatement ps = con.prepareStatement(query1);
			ps.setFloat(1, amount);
			ps.setInt(2, accountNumber2);
			ps.execute();

			PreparedStatement ps4 = con.prepareStatement(insertfund);
			ps4.setString(1, fdt);
			ps4.setInt(2, accountNumber);

			ps4.execute();

			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;
	}

	public void printTransaction() {

		accountNumber = acn;
		Connection con = util.getConnection();
		try {
			Statement st = con.createStatement();
			String query = "select * from transactions where accountNumber = '" + accountNumber + "'";

			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				details = rs.getString("transaction_info");
				System.out.println(details);

			}
			con.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}