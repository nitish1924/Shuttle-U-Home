package bean;

public class Booking {
	
	private String name;
	private String address;
	private String email;
	private String date;
	private String status;
	private String driver;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public void setStatus(String status) {
		this.status=status;
		
	}
	public String getStatus() {
		return status;
	}
	
}
