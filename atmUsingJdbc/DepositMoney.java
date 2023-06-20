package atmUsingJdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DepositMoney {
	String accNo;
	int amount;
	 DepositMoney(String accNo,int amount)
	 {
		 this.amount=amount;
		 this.accNo=accNo;
	 }
	//update balance
	 void updateBalance() throws ClassNotFoundException, SQLException{
	     Class.forName("com.mysql.cj.jdbc.Driver");
	     Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm","root","mysql123");
	     PreparedStatement ps = con.prepareStatement("update userdata set balance=? where accNo=?");
	     int balance = BalanceEnquiry.getBalance(accNo);
	     int x= balance+amount;
	     ps.setInt(1, x);
	     ps.setString(2,accNo);
	     int row=ps.executeUpdate();
	     if(row>0)
	     {
	       System.out.println("Transaction Succesfull!");
	     }else {
	       System.err.println("Error Occurred");
	     }

	 }
}
