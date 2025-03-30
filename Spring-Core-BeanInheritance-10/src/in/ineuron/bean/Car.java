package in.ineuron.bean;

	
public class Car 
{
	private String regNo;
	private int engineNo;
	private String type;
	private String model;
	private String company;
	private String color;
	private int engineCC;
	private String owner;
	private String fuelType;
	public String getRegNo() {
		return regNo;
	}
	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}
	public int getEngineNo() {
		return engineNo;
	}
	public void setEngineNo(int engineNo) {
		this.engineNo = engineNo;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getEngineCC() {
		return engineCC;
	}
	public void setEngineCC(int engineCC) {
		this.engineCC = engineCC;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getFuelType() {
		return fuelType;
	}
	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}
	@Override
	public String toString() {
		return "Car [regNo=" + regNo + ", engineNo=" + engineNo + ", type=" + type + ", model=" + model + ", company="
				+ company + ", color=" + color + ", engineCC=" + engineCC + ", owner=" + owner + ", fuelType="
				+ fuelType + "]";
	}
	
	
	
}
