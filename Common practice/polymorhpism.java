class animal{
	void func() {
		System.out.println("Animal is printed");
	}
}

class dog extends animal{
	 void func() {
		System.out.println("dog is printed");
	}
}

public class polymorhpism {

	public static void main(String[] args) {
		animal x=new dog();
		x.func();
		animal y=new animal();
		y.func();

	}

}
