	
public class subarray01 {

	public static void main(String[] args) {
		
		int arr[]= {0,0,0,1,1,1};
		int len=arr.length;
		//System.out.println(len);
		subarray01.func(arr,len);

	}
	public static void func(int arr[], int len) {

		int start_index=0,end_index=0,sum,max=-1;
		for(int i=0;i<len;i++) {
			if(arr[i]==0)
				sum=-1;
			else
				sum=1;
			
			for(int j=i+1;j<len;j++) { // loop to sub arrays starting from i
				
				if(arr[j] == 0)   
                    sum=sum-1;  
                else
                    sum=sum+1; 

                if (sum==0 && max<(j-i)) //if size of a sub array is greater than maximum size then update max
                { 
                    max=j-i; 
                    start_index=i; 
                } 
				
			}
		}
		end_index=start_index+max; 
        if (max==-1) 
            System.out.println("No sub-array found"); 
        else
            System.out.println(start_index+" to "+end_index); 
        
	}
	
}
