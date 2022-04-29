import java.util.Scanner;

public class temp {

	public static void main(String[] args) {
		int option=10;
		Scanner input = new Scanner(System.in);
		while(option!=0) {
			System.out.println("Enter: ");
			option=input.nextInt();
			System.out.println(option);
		}
    }
}