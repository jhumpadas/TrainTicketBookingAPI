package RequestBean;

import entity.Seat;

public class ModifySeatRequestBean {
	private Seat seat;
	private String userEmail;
	public Seat getSeat() {
		return seat;
	}
	public void setSeat(Seat seat) {
		this.seat = seat;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	
}
