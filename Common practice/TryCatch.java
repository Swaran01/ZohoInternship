public class TryCatch {

	 public static void main(String[] args) {
		
		 try {
			   int i;
			  String a = "Swaran";
			  i= Integer.parseInt(a);
			  System.out.println(a);
			  System.out.println(i);
			 }catch(Exception e) {System.out.println(e);}
	 }
}