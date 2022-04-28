import java.util.Scanner;

public class stringlineallocation {  
    public static void main(String[] args) {  
        String string;  
        int width;    
        Scanner input = new Scanner(System.in);
		System.out.print("Enter the String: ");
		string=input.nextLine();
		System.out.print("Enter the line width: ");
		width=input.nextInt();
		//int text_length=string.length();
        String letters[] = string.split(" ");
        //System.out.println(letters[1]);
        int length=letters.length;
        System.out.println("\nTotal number of words: "+length);
        int string_length[]=new int[length];
        for(int i=0;i<length;i++)
        {
        	string_length[i]=letters[i].length();
        	System.out.println("Length of Word "+(i+1)+": "+string_length[i]);
        }
        int temp=0;
        for(int j=0;j<length+1;j++) {
        	temp=temp+string_length[j];
        	if(temp<width) {
        		//temp=temp+string_length[j];
        		System.out.print(letters[j]+" ");        		
        	}
        	else{
        		temp=0;
        		System.out.println("");
        		temp=string_length[j]+1;
        		System.out.print(letters[j]+" ");
        	}
        	
        }input.close();
        
        
    }
} 