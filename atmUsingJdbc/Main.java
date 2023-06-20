package atmUsingJdbc;
import java.sql.SQLException;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		 int amount;
		 Scanner inp= new Scanner(System.in);
		 System.out.println("Enter :\n1.Sign up\n2.Login");
		 int choice = inp.nextInt();
		 if(choice==1)
		 {
			SignUp su = new SignUp();
			su.register();
		 }
		 else if(choice==2)
		 {
			 SignIn si = new SignIn();
			 si.login();
		 }
		 String accNo = SignIn.getAccNo();
		while(true)
		{
			System.out.println("Welcome! Enter your choice:\n1.Deposite Money\n2.Withdraw Money\n3.Balance enquiery\n4.Change Pin\n5.Exit");
			int ch=inp.nextInt();
			switch(ch)
			{
			 case 1:
				System.out.println("Enter the amount to deposit: ");
				amount = inp.nextInt();
				DepositMoney dm = new DepositMoney(accNo,amount);
				dm.updateBalance();
				break;
			 case 2:
				 System.out.println("Enter the amount to Withdraw: ");
				  amount = inp.nextInt();
				 WithdrawMoney wd = new WithdrawMoney(accNo,amount);
				 wd.canDraw(accNo);
				 break;
			 case 3:
				 System.out.println("Balance : "+BalanceEnquiry.getBalance(accNo));
				 break;
			 case 4:
				 ChangePin cp = new ChangePin(accNo);
				 cp.procedure();
				 break;
			 case 5: 
				 System.exit(0);
			}
		}
		 
	}

}
