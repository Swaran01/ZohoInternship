
public class conditional {

	public static void main(String[] args) {
		
		 Conditional();
		 System.out.println('\n');
		 ternary();
		 System.out.println('\n');
		 ifelse();
		 
		
	}
	public static void Conditional() {
		
		int a=2,b=8,c=5;  
		System.out.println(a>b && a>c || b<c);  
		System.out.println((a<c||b>c) && a<b); 
		
	}
	public static void ternary() {
		
		int a=2,b=5;
		System.out.println((a%2==0) ? "even": "odd");
		System.out.println((b%2==0) ? "even": "odd");
		
	}
	public static void ifelse() {
		
		int a=3,b=3;
		if(a>b) {
			System.out.println("A is greater");
		}
		else if(a<b) {
			System.out.println("B is greater");
		}
		else{
			System.out.println("A is equal to B");
		}
		
	}

}
