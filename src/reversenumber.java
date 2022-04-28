class reverse{
	int temp,reverse=0;  //declaration for temporary variable and reverse variable to store reverse value
 	 public void func(int i) {   //method to implement the reverse function
		while(i!=0) {
			temp=i%10;
			reverse=(reverse*10)+temp;
			i=i/10;
		}
		System.out.println("The reverse number is " + reverse);
	}
}

public class reversenumber {

	public static void main(String[] args) {
		int number=586400;
		reverse x=new reverse();
		x.func(number);
		

	}

}
