package ResponseBean;

import entity.User;

public class GetTicketResponseBean {
	private int status ;
	private String message;
	private String errMessage;
	private User passenger;
	private int seatNo;
	private int amountPaid;
	private String from;
	private String to;
	
	
	
	public int getAmountPaid() {
		return amountPaid;
	}
	public void setAmountPaid(int amountPaid) {
		this.amountPaid = amountPaid;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	
	
	public int getSeatNo() {
		return seatNo;
	}
	
	public User getPassenger() {
		return passenger;
	}
	public void setPassenger(User passenger) {
		this.passenger = passenger;
	}
	
	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}
	public int getStatus() {
		return status;
	}
	public String getMessage() {
		return message;
	}
	public String getErrMessage() {
		return errMessage;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setErrMessage(String errMessage) {
		this.errMessage = errMessage;
	}
	
	
}
