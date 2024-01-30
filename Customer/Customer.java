public class Customer{
	//---------Attribute declarations--------------
	private String id;
	private String name;
	private String address;
	private double salary;
	
	//---------Methods declarations--------------
	public Customer(String id, String name, String address, double salary){
		this.id=id;
		this.name=name;
		this.address=address;  
		this.salary=salary;
	}
	public void setId(String id){
		this.id=id;
	}
	public void setName(String name){
		this.name=name;
	}
	public void setAddress(String address){
		this.address=address;
	}
	public void setSalary(double salary){
		this.salary=salary;
	}
	public void printCustomerDetails(){
		System.out.println("["+id+","+name+","+address+","+salary+"]");
	}
	public String getId(){
		return this.id; //return id;
	}
	public String getName(){
		return this.name;
	}
	public String getAddress(){
		return this.address;
	}
	public double getSalary(){
		return this.salary;
	}
	public String getCustomerDetails(){
		return "["+id+","+name+","+address+","+salary+"]";
	}
}
