package entity;

public class User {
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private boolean hasBookedTicket;
	
	
	public User(int id, String firstName, String lastName, String email, boolean hasBookedTicket) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.hasBookedTicket = hasBookedTicket;
	}

	public boolean isHasBookedTicket() {
		return hasBookedTicket;
	}
	
	public void setHasBookedTicket(boolean hasBookedTicket) {
		this.hasBookedTicket = hasBookedTicket;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
