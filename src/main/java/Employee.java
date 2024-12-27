
public class Employee {
	
	private String id;
	
	private String name;
	
	private int salary;
	
	private String email;
	
	private String phone;
	
	private String address;

	public Employee(String id, String name, int salary, String email, String phone, String address) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}

	public Employee(String name, int salary, String email, String phone, String address) {
		super();
		this.name = name;
		this.salary = salary;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}

	public Employee() {
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
