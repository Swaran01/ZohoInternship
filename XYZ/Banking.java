package XYZ;

import java.sql.ResultSet;
import java.lang.Exception;
import java.util.Scanner;

interface BalanceFunc{
	int balanceCheck(String userName) throws Exception;
	void balanceUpdate(String userName, double balance) throws Exception;
}
interface BankingOptions{
	void swipe(String user);
	void withdrawal(String userName);
}

class Balance implements BalanceFunc{  //class to check the balance details and balance update after all transactions
	
	/*
	 * method to check the balance before 
	 * each transaction and to check 
	 * balance from user input 
	 */
	public int balanceCheck(String user) throws Exception {
		
		DBconnect DB= new DBconnect();  //creating object for the database connecting class
		String sqlQuery="select customer_balance from customer_details where customer_username='"+user+"'";  //sql query is assigned to the string variable
		DB.dbMain();  //calling the method in the database connecting class to connect the this method with the mysql db
		ResultSet resultSet = DB.statement.executeQuery(sqlQuery);   //creating the object to store the result set values that are obtained from the db
		resultSet.next();   //initializing to seek from the next row as the first row is with the header names
		return resultSet.getInt(1); //returning the balance value from database to the called method
		 }
	
	/*
	 * method to update the balance 
	 * after each transaction.
	 */
	public void balanceUpdate(String user,double balance)throws Exception {
		DBconnect DB= new DBconnect();  //creating object for the database connecting class
		String sqlQuery="update customer_details set customer_balance="+balance+" where customer_username='"+user+"'";  //sql query is assigned to the string variable
		DB.dbMain();  //calling the method in the database connecting class to connect the this method with the mysql db
		DB.statement.executeUpdate(sqlQuery);   //executing the sqlquery to update the result value to the db
	}
}

class Banking extends Balance implements BankingOptions {  //class to execute all banking functionality
	 
	 /*
	  * method to execute the swipe transaction 
	  * with respective to the cashback obtained 
	  * and updating the balance in the db
	  */
	public void swipe(String userName){   //method for swipe transaction
		
		try {
			double amount,cashback;
			double balance=balanceCheck(userName);
			if(balance>100) {
				Scanner input = new Scanner(System.in);   //creating object for scanner package
				System.out.print("Enter the amount for swipe transaction: ");
				amount=input.nextInt();//input from customer
				LoadingAnimationForBanking objForLoadingAnimation=new LoadingAnimationForBanking(); 
				objForLoadingAnimation.run();
				if(amount<balance && amount>1) {
					balance=balance-amount;   //remaining balance after debit
					cashback=amount*0.01;   //formula for cashback
					balance=balance+cashback;
					balanceUpdate(userName,balance);
					System.out.println("\nTransaction Completed.\n\nThank you for Purchasing for "+amount+"$, You have earned cashback of "+cashback+"$");
					System.out.println("Balance: "+(int)balance+"$");
				}
				else
					System.out.println("\nTransaction Failed.\n\nTransaction failed due to insufficient balance\nBalance:  "+balance+"$");
					
				
			}
			else
				System.out.println("\nTransaction failed due to minumum balance\nBalance: "+balance+"$");
		}catch(Exception e) {
			System.out.println("Error");
		}
				
	}
	
	/*
	 * method to execute the withdrawal transaction
	 *  with respect to the service charges applied 
	 *  for the amount of withdrawal during the 
	 *  transaction and updating the balance in the db
	 */
	public void withdrawal(String userName){   //method for swipe transaction
		try {
			double amount,serviceCharge;   
			double balance=balanceCheck(userName);
			if(balance>100) {
				Scanner input = new Scanner(System.in);   //creating object for scanner package
				System.out.print("Enter the amount for Withdraw Cash: ");
				amount=input.nextInt();   //input from customer
				LoadingAnimationForBanking objForLoadingAnimation=new LoadingAnimationForBanking(); 
				objForLoadingAnimation.run();
				//input.close(); //killing the scanner object
				
				if(amount%5==0) {
					if(amount<100)
						serviceCharge=amount*0.02;   //formula for service charges below 100$ transactions
					else
						serviceCharge=amount*0.04;  //formula for service charges above 100$ transactions
					if(amount+serviceCharge<balance && amount>1) {
						   
						balance=balance-serviceCharge-amount;  //calculating final balance after transactions
						balanceUpdate(userName,balance);
						System.out.println("\nTransaction Completed.\n\nThank you for Withdrawing Cash for "+amount+"$, service charge of "+(int)serviceCharge+"$ has been debited.");
						System.out.println("Balance: "+(int)balance+"$");   //printing the whole ATM transaction details
					}

					else
						System.out.println("\nTransaction Failed.\n\nTransaction failed due to insufficient balance\nBalance:  "+(int)balance+"$");
					
				}
				else
					System.out.println("\nTransaction Failed.\n\nPlease enter amount that is multiple of 5.");   //if input is not multiple of 5
			}
			else
				System.out.println("\nTransaction failed due to minumum balance\nBalance: "+(int)balance+"$");
		}catch(Exception e) {
			System.out.println("Error");
		}
		
	}
	
	/*
	 * method to print the balance if customer 
	 * selected the show balance option, the 
	 * balanceCheck method is called from 
	 * the balance class to obtain the 
	 * balance value from the db
	 */
	void balance(String userName) throws Exception {
		double balance=balanceCheck(userName);
		LoadingAnimation objForLoadingAnimation=new LoadingAnimation(); 
		objForLoadingAnimation.run();
		System.out.println("\n\nYour Bank balance is "+(int)balance+"$");   //Method to show balance only
	}
	
}