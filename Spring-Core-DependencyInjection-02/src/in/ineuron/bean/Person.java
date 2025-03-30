package in.ineuron.bean;

public class Person {
	private Integer pid;
	private String pname;
	private String paddress;
	private float income;
	
	static{
		System.out.println("Person .class file is loading..");
	}
	public Person()
	{
		System.out.println("Person object is instantiate by using Zero arg constructor");
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public void setPaddress(String paddress) {
		this.paddress = paddress;
	}
	public void setIncome(float income) {
		this.income = income;
	}
	public Person(Integer pid, String pname, String paddress, float income) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.paddress = paddress;
		this.income = income;
	}
	@Override
	public String toString() {
		return "Person [pid=" + pid + ", pname=" + pname + ", paddress=" + paddress + ", income=" + income + "]";
	}
	
}
