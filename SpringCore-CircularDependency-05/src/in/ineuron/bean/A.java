package in.ineuron.bean;

public class A {
	private B b;
	
	static{
		System.out.println("A.class is loading...");
	}
	
	public A()
	{
		System.out.println("A class is instantiated");
	}


	public void setB(B b) {
		this.b = b;
	}

	@Override
	public String toString() {
		return "A [b=" + b + "]";
	}
	
}
