
public class numberreplaceinarray {

	public static void main(String args[]) 
    { 
        int arr[]= {2, 4, 8, 90, 77, 54};
        int arr_len = arr.length; 
        func(arr, arr_len); 
    } 
	
	static void func(int arr[], int len) 
    { 
        int greater; 
        for (int i=0; i<len; i++) 
        { 
            greater = -1; 
            for (int j = i+1; j<len; j++) 
            { 
                if (arr[i] < arr[j]) 
                { 
                	for(int k=j;k<len;k++) {
                		if(arr[j]>arr[k] && arr[i]<arr[k])
                			greater=arr[k];                //greater = arr[j]; for reference only 
                                               
                	}
                	break;
                } 
            } 
            System.out.println(greater); 
        } 
    } 
       
}
