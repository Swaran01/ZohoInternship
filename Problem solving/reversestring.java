import java.util.Scanner;

public class reversestring {

	public static void main(String[] args) {
		String str,rev;
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the String to Reverse: ");
		str=input.nextLine();
		StringBuilder strbldr=new StringBuilder(str);
		System.out.println("The reversed string is: ");
		System.out.println(strbldr.reverse());
		

	}

}
