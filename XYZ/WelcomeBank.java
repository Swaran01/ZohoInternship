package XYZ;

public class WelcomeBank extends Thread {
	
	/*
	 * method to print the Welcome message 
	 * to the bank with an animated text 
	 * effect using thread sleep methods
	 */
 static void welcomeText() throws Exception {
	 String bank="XYZ BANK Welcomes you!";  //declaring the welcome message
	 String letters[] = bank.split("");  //spliting the string into an array of characters
	 int stringLength=bank.length();   //calculating the string length to limit the arrayIndex value in the nested loop
	 for(int arrayIndex=0;arrayIndex<stringLength;arrayIndex++) {
		 System.out.print(letters[arrayIndex]);  //printing the letters letter by letter with the thread sleep method
		 
		 Thread.sleep(100);   // thread to sleep to show the animation effect
		 
	 }
 }
 
}
