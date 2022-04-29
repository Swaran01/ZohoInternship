import java.lang.Math;

public class steppingnumbers {
	void firstlast(int a, int count) {//to find if first and last digit values are adjacent to value 1 then pass to next method
		int i,j;
		i=a/(int)Math.pow(10,count-1);
		//j=
	}

	public static void main(String[] args) {
		
		int a=0,b=200;
		
		if(a/10==0) {//to print the numbers if a starts from single digit as single are stepping number
			while(a!=10) {
				System.out.println(a +" ");
				a++;
			}
		}
		
		while(a!=b) {
			int count = 0, temp;
			temp=a;
		    while (temp != 0)//to find the number of digits
		    {
		        temp = temp / 10;
		        count++;
		    }
		    //System.out.println(count +"  is the digit count");
		    
		    
		    
		    
		    a++;
		}
		//System.out.println(a +" value of a");
	}

}
