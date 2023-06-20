package atmUsingJdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ChangePin {
	Scanner inp1 = new Scanner(System.in);
	  String accNo;
	  ChangePin(String accNo)
	  {
		  this.accNo=accNo;
	  }
	  //procedure
	   void procedure() throws ClassNotFoundException, SQLException
	   {
		      System.out.println("Enter the new pin: ");
		      String pin1=inp1.next();
		      System.out.println("Confirm pin: ");
		      String pin2=inp1.next();
		      if(pin1.equals(pin2))
		      {
		    	 updateDB(accNo,pin1);
		      }else {
		    	  System.err.println("Didn't match");
		      }
		}
	  
      //update DB
       void updateDB(String accNo, String pin) throws ClassNotFoundException, SQLException
      {
    	//update db
         Class.forName("com.mysql.cj.jdbc.Driver");
 	     Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm","root","mysql123");
 	     PreparedStatement ps = con.prepareStatement("update userdata set pinCode=?  where accNo=?");
 		 ps.setString(1, pin);
 	     ps.setString(2,accNo);
 		 int row=ps.executeUpdate();
 		 if(row>0)
 		  {
 		    System.out.println("Pin Changed Succesfull!");
 		  }else {
 		    System.err.println("Error Occurred");
 		  } 
 
      }
}
