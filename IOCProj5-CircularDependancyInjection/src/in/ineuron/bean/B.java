package in.ineuron.bean;

public class B {
	private A a;
	
	static {
		System.out.println("B.class file is loading...");
	}
	
	public B() {
		System.out.println("B object is instantiated...");
	}

	public void setA(A a) {
		this.a = a;
	}

	@Override
	public String toString() {
		return "B [a=" + a + "]";
	}

}
