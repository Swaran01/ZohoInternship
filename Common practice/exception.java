
public class exception {

	public static void main(String[] args) {
		try {
			int i=100/0;
			System.out.println(i);
		}catch(Exception e) {System.out.println(e);}
		try {
			String s=null;
			System.out.println(s.length());
		}catch(Exception e1) {System.out.println(e1);}
		try {
			int a[]=new int[5];  
			a[10]=50;
			System.out.println(a);
		}catch(Exception e2) {System.out.println(e2);}
		System.out.println("hello");
		
		

	}

}
