package atmUsingJdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SignIn {
	      
		   static String accNo="";
          void login() throws SQLException, ClassNotFoundException
          {
        	  Scanner inp = new Scanner(System.in);
        	  System.out.println("Account Number: ");
        	  accNo = inp.next();
        	  System.out.println("Pin Code: ");
        	  String pinCode = inp.next();
        	  Class.forName("com.mysql.cj.jdbc.Driver");
      		  Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm","root","mysql123");
      		  Statement s = con.createStatement();
              ResultSet rs=s.executeQuery("select * from userdata where accNo=\""+accNo+"\";");
              //didnt write condition for if query fails
              String pin="";
    		  String name="";
              while(rs.next()) {
    			 pin=rs.getString(2);
    			 name = rs.getString(3);
    		  }
      		  if(pinCode.equals(pin))
      		  {
      			System.out.println("WELCOME "+name.toUpperCase()+"!"); 
      		  }
      		  else {
      			  System.err.println("Invalid Credentials");
      			  System.exit(0);
      		  }
          }
         public static String getAccNo()
         {
        	 return accNo;
         }
		
}
