package in.ineuron.bean;

public class Student {
	private Integer sid;
	private String name;
	private String address;
	private Integer age;
	static{
		System.out.println(".class file loading...");
	}
	public Student()
	{
		System.out.println("Instantiation Phase... ");
	}
	public Integer getSid() {
		System.out.println("Student.getSid");
		return sid;
	}
	public void setSid(Integer sid) {
		System.out.println("Student.setSid");
		this.sid = sid;
	}
	public String getName() {
		System.out.println("Student.getName");
		return name;
	}
	public void setName(String name) {
		System.out.println("Student.setName");
		this.name = name;
	}
	public String getAddress() {
		System.out.println("Student.getAddress");
		return address;
	}
	public void setAddress(String address) {
		System.out.println("Student.setAddress");
		this.address = address;
	}
	public Integer getAge() {
		System.out.println("Student.getAge");
		return age;
	}
	public void setAge(Integer age) {
		System.out.println("Student.setAge");
		this.age = age;
	}
	
}
