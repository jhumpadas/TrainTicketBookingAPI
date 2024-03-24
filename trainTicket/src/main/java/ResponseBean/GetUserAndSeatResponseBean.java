package ResponseBean;

import java.util.List;

import entity.Seat;

public class GetUserAndSeatResponseBean {
	private int status;
	private String message;
	List<Seat> userSeatdetails;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<Seat> getUserSeatdetails() {
		return userSeatdetails;
	}
	public void setUserSeatdetails(List<Seat> userSeatdetails) {
		this.userSeatdetails = userSeatdetails;
	}
	
	
}
