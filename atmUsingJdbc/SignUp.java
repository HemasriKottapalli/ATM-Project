package atmUsingJdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class SignUp {

	   void register() throws ClassNotFoundException, SQLException {
		Scanner inp = new Scanner(System.in);
		 String accNo;
		 String pinCode;
		 String name;
		 int age;
		 String address;
		 int balance=0;
		 System.out.println("Account Number: ");
		 accNo=inp.next();
		 System.out.println("Pin code: ");
		 pinCode=inp.next();
		 System.out.println("Name: ");
		 inp.nextLine();
		 name=inp.nextLine();
		 System.out.println("Age: ");
//		 inp.nextInt();
		 age=inp.nextInt();
		 System.out.println("Address: ");
		 address=inp.next();
		 
		 Class.forName("com.mysql.cj.jdbc.Driver");
		 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm","root","mysql123");
		 PreparedStatement ps = con.prepareStatement("insert into userdata values(?,?,?,?,?,?);");
		 ps.setString(1, accNo);
		 ps.setString(2, pinCode);
		 ps.setString(3, name);
		 ps.setInt(4, age);
		 ps.setString(5, address);
		 ps.setInt(6, balance);
		 ps.executeUpdate();
	}

}
