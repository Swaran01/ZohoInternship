package XYZ;
import java.util.Scanner;

public class XYZ_Bank {
	/*
	 * main class for XYZ Bank application
	 */
	public static void main(String[] args)throws Exception{  
		Banking objForBanking=new Banking();                 //creating object for Banking class
        CheckCredentials objForAuthentication=new Authentication();  //creating object for the Authentication class
		Scanner input = new Scanner(System.in);    //creating object for Scanner class
		WelcomeBank.welcomeText();  //showing the welcome bank text with animation using thread
		System.out.print("\nUsername: ");	
		String userName=input.nextLine(); //input for username
		System.out.print("Pin: ");	
		int userPin; 
		try {
			userPin=input.nextInt();  //input for pin
		}catch(Exception e) {
			userPin=0;  // shows error if the user enters string instead of int, so if string entered the variable value is declared
		}
		
		LoadingAnimationForAuthentication objForAuthenticationAnimation=new LoadingAnimationForAuthentication();   //creating object for Loading animation class
		objForAuthenticationAnimation.run();   //calling the run method from the loading animation class with object
		if(objForAuthentication.checkCredentials(userName, userPin)) {   //to check the username and pin are correct with database connectivity 
			int bankingChoice;   //variable for getting input for banking choice
			WelcomeCustomer.customerWelcome(userName);   //method to print welcome message with name and balance
			while(true) {  //looping until it breaks in the function when 0 is typed in the switch case
				System.out.println("\nSwipe Transactions- press 1 || Cash Withdrawal- press 2 || Check Balance- press 3 || End Banking- 0");  //Printing the options that customer has to select within
				System.out.print("Enter: ");    
				try {
					input.nextLine();
					bankingChoice=input.nextInt();//input for mode of banking
					
					switch(bankingChoice) {   //switch choice option for banking
					case 1://for swipe transaction
						objForBanking.swipe(userName);
						break;
	                case 2://for cash withdrawal
	                	objForBanking.withdrawal(userName);
						break;
	                case 3://for only showing balance
	                	objForBanking.balance(userName);
	                	break;
	                case 0://to end the banking 
	                	System.out.println("\nThank you for Banking with XYZ Bank, We look forward to serve you again.");
	                	return;
	                default://if wrong input entered in options
	                	System.out.println("Wrong Input entered");
	                	break;
					}
				}catch(Exception e) {
					System.out.println("Wrong Input entered");  //if string is entered in the int section
					
				}
				
			}
		}
		else {
			System.out.println("Authentication Failed.\n\nIncorrect Credentials, Please re-insert the card to try again.");  //for incorect pin
		}
		
		
	input.close(); //killing the scanner object

	}

}
