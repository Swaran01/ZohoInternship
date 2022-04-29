import java.util.Scanner;

public class repeatingsubstring {
    public static String removeWord(String string, String word)
    {  
        String master = string;
        String to_remove=word;
        String new_string = master.replace(to_remove, "");
        return new_string;
    }

    
    static String longestRepeatedSubstring(String str) {

	        int n = str.length();
	        int LCSRe[][] = new int[n + 1][n + 1];
	        String res = ""; // To store result 
	        int res_length = 0; // To store length of result 
	        // building table in bottom-up manner 
	        int i, index = 0;
	        for (i = 1; i <= n; i++) {
	        	for (int j = i + 1; j <= n; j++) {
	        		// (j-i) > LCSRe[i-1][j-1] to remove 
	        		// overlapping 

	                if (str.charAt(i - 1) == str.charAt(j - 1) && LCSRe[i - 1][j - 1] < (j - i)) {
	                	LCSRe[i][j] = LCSRe[i - 1][j - 1] + 1;
	                	// updating maximum length of the substring and updating the finishing index of the suffix
	                    if (LCSRe[i][j] > res_length) {
	                    	res_length = LCSRe[i][j];
	                    	index = Math.max(i, index);

	                    }

                } else {

                    LCSRe[i][j] = 0;

                }

            }

        }
	 

	        // If we have non-empty result, then insert all characters from first character to last  character of String   

        if (res_length > 0) {

            for (i = index - res_length + 1; i <= index; i++) {

                res += str.charAt(i - 1);

            }

        }
	 

        return res;

    }
	 
	// Driver program to test the above function 

    public static void main(String[] args) {
        String str,s;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the string to find the substring: ");
        str = input.nextLine();
        str = str.replaceAll("\\s", "");
        str = str.toLowerCase();
        int f=0;
        while(true)
        {
        	if((s=longestRepeatedSubstring(str)).isEmpty())
        	{
        		if(f==0)
        			System.out.print("none");
        		break;
        	}
        	else
        	{
        		if(s.length()>2) //length of the repeating substring
        		{
	        		f++;
        		System.out.print(s+" ");
        	}
        		str=removeWord(str,s);
        		// System.out.println(str);
        	}
        }
       input.close(); 

    }
}