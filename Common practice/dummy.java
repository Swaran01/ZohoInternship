package dummy;

class human {
	private  void eat() {

		System.out.println("hi");
	}
	  void run() {
		eat();
	}
}



class student extends human{
	int a=2;
	void sleep() {
		run();
	}
}

public class Main {
	public static void main(String arg[]) {
		human x=new student();
		student s=(student)x;
		x.eat();
		s.eat();
		//x.run();
		
	}

}
