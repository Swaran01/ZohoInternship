class a{
	 void func1() {
		System.out.println("Function 1 from class A");
	 }
}

class b extends a{
	public void func2() {
		System.out.println("Function 2 from class B");
	}
}

class c extends b { 
	public void func3() {
		System.out.println("Function 3 from class C");
	}
}


public class multilevel {

	public static void main(String[] args) {
            c x= new c();
            x.func1();
            x.func2();
            x.func3();
	}

}
