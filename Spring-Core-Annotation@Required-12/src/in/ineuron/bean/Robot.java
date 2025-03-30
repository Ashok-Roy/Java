package in.ineuron.bean;

import org.springframework.beans.factory.annotation.Required;

public class Robot 
{
	private Integer id=123;
	private String name;
	private Double price;
	private String lab;
	
	
	
	public Integer getId() {
		return id;
	}
	@SuppressWarnings("deprecation")
	@Required
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	@SuppressWarnings("deprecation")
	@Required
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getLab() {
		return lab;
	}
	public void setLab(String lab) {
		this.lab = lab;
	}
	@Override
	public String toString() {
		return "Robot [id=" + id + ", name=" + name + ", price=" + price + ", lab=" + lab + "]";
	}
	
	

}
