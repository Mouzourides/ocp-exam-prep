public class AbstractInnerClass {
	static int y = 0;

public static void main(String[] args){
	abstract class A {
		public abstract int calc(int x);
	}	

	A a = new A() {
		public int calc(int x){return x*y;}
		public void print(int x){System.out.println(calc(x));}
	};

	System.out.println(a.calc(2));

	}
}
