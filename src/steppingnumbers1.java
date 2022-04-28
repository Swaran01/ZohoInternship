import java.util.Scanner;
import java.lang.Math;

public class steppingnumbers1 {
	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in); //creating object for the scanner library for data input
		int start_range,end_range,size,last_digit,first_digit,z=0;
		System.out.print("Enter the starting number:");
		start_range = input.nextInt();
		System.out.print("Enter the ending number:");
		end_range = input.nextInt();
		for(int num =start_range;num<=end_range;num++) //main for loop
		{
		if(num<10) //for printing stepping number as one digits are considered so
		    System.out.println(num+" is a stepping number");
		else {
			size= (int) (Math.log10(num)); //To find the digits in the number-1
			first_digit= num/(int)Math.pow(10,size);
			last_digit = num%10;
			if(first_digit==last_digit+1 || first_digit==last_digit-1) { //finding if first and last digit are stepping values
				int temp=num,x=1;
				while(true) {
					int i = temp%10;
					int j = (temp = temp/10);
					if(j<10) {
						if(i==j+1 || i==j-1)
						    break;
						else {
							x=0;
							break;
						}
					}
						if(i==(j%10)+1 || i==(j%10)-1) {
							x=1;
						}
						else {
							x=0;
							break;
						}
						};
						if(x==1){
			                System.out.println(num +" is a stepping number");
			                z++;
						}
     					}				
				}
			}
			if(z==0)
						System.out.println("No stepping number available in given range");
		}
}