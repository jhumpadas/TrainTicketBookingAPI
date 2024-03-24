package entity;

public class Seat {
	private int seatNo;
	private boolean isEmpty;
	private User passenger;
	private String section;
	
	
	
	
	public Seat(int seatNo, boolean isEmpty, String section) {
		this.seatNo = seatNo;
		this.isEmpty = isEmpty;
		this.section = section;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public User getPassenger() {
		return passenger;
	}
	public void setPassenger(User passenger) {
		this.passenger = passenger;
	}
	public Seat(int seatNo, boolean isEmpty) {
		this.seatNo = seatNo;
		this.isEmpty = isEmpty;
	}
	public int getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}
	public boolean isEmpty() {
		return isEmpty;
	}
	public void setEmpty(boolean isEmpty) {
		this.isEmpty = isEmpty;
	}
	
	
	
}
