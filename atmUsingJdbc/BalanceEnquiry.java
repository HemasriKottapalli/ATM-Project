package atmUsingJdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BalanceEnquiry {
	//get balance
	static int getBalance(String accNo) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm","root","mysql123");
		Statement s = con.createStatement();
	    ResultSet rs=s.executeQuery("select * from userdata where accNo=\""+accNo+"\";");
	    //didnt write condition for if query fails
	    int balance=0;
	    while(rs.next()) {
			balance=rs.getInt(6);
		  }
		return balance;
	}
}
