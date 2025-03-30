package in.ineuron.bean;

public class Person 
{
	private String name;
	private Integer pid;
	private String paddress;
	private float income;
	
	
	static{
		System.out.println("Person class is loading and .class file only one...");
	}
	
	public Person()
	{
		System.out.println("Person class is Instentiate using zero arg-constructor..");
	}
	
	
	// Setter Injection
	
	public void setName(String name) {
		System.out.println("Person.setName()");
		this.name = name;
	}
	
	public void setPid(Integer pid) {
		System.out.println("Person.setPid()");
		this.pid = pid;
	}
	
	public void setPaddress(String paddress) {
		System.out.println("Person.setPaddress()");
		this.paddress = paddress;
	}

	public void setIncome(float income) {
		System.out.println("Person.setIncome()");
		this.income = income;
	}
	
	
	// Constructor Injection
	public Person(String name, Integer pid, String paddress, float income) {
		System.out.println("Person object is created using constructor injection");
		this.name = name;
		this.pid = pid;
		this.paddress = paddress;
		this.income = income;
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", pid=" + pid + ", paddress=" + paddress + ", income=" + income + "]";
	}
	
	

}
