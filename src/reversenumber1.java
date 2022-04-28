
public class reversenumber1 {
	public static void func(int i) {
		
		int temp,rev=0;
		while(i!=0) {
			temp=i%10;
			rev=(rev*10)+temp;
			i=i/10;
		}
		System.out.println("The reverse number is " + rev);
	}
	

	public static void main(String[] args) {
		
		int i=5864;
		reversenumber1.func(i);
		
	}

}
