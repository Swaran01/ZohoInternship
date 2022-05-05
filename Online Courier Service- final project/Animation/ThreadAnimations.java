package Animation;

interface LoadingThreadAnimation{
	void run();
}

public class ThreadAnimations extends Thread implements LoadingThreadAnimation {

	/*
	 * method to print the loading 
	 * animation for Authentication 
	 * loading purposes.
	 */
	@Override  //to override the below method
	public void run() {  //run method to run the animation effect (even start can be used)
        System.out.print("Authenticating Credentials");
        
        for(int loopIndex=0;loopIndex<3;loopIndex++) {
			System.out.print(".");
			try {
			    Thread.sleep(700);   // thread to sleep to show the animation effect
			}catch(Exception e) {}	
		}
        System.out.println("");
        
		for(int loopIndex=0;loopIndex<26;loopIndex++) {
			System.out.print("#");
			try {
			    Thread.sleep(20);   // thread to sleep to show the animation effect
			}catch(Exception e) {}	
		}
		System.out.println("");
			
	}
	
}
 class d
