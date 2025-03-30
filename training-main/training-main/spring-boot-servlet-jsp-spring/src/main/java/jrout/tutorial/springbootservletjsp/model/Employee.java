package jrout.tutorial.springbootservletjsp.model;

public class Employee {

    private int empId;
    private String fname;
    private String lname;
    private String address;
    private float salary;

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public Employee(int empId , String fname){
        this.empId = empId;
        this.fname = fname;
    }
    public Employee(int empId , String fname, String lname){
        this.empId = empId;
        this.fname = fname;
        this.lname = lname;
    }
    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
