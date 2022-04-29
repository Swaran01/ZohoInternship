class animals{
	public void func(int i) {
		System.out.println("Animal is printed");
	}
}
class birds extends animals{
	
	public void func() {
		System.out.println("bird is printed");
	}
}

public class overloading {

	public static void main(String[] args) {
		int a;
		a=2;
		birds i=new birds();
		i.func(a);
		i.func();
    }

}