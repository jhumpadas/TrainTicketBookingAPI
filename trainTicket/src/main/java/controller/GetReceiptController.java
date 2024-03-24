package controller;

import ResponseBean.GetReceiptResponseBean;
import entity.Seat;
import entity.User;
import service.TicketService;
import service.UserService;

@RestController
public class GetReceiptController {
	TicketService ticketService = new TicketService();
	UserService userService = new UserService();

	//This API is for point number 6
	@GetMapping("/getReceipt/{email}")
	public  ResponseEntity<> getReceiptforUser(@PathVariable String email){
		GetReceiptResponseBean getReceiptResponseBean = new GetReceiptResponseBean();
		try {
			if(email == null || email.trim().equals(""))
			{
				throw new InvalidUserException("Entered email is null or Empty");
				getReceiptResponseBean.setStatus(0);
				getReceiptResponseBean.setMessage("Please enter a valid email");
				return new ResponseEntity<>(getReceiptResponseBean, HttpStatus.BAD_REQUEST);
			}
			
			User u = userService.getUserByEmail(email);
			
			if(u == null) {
				getReceiptResponseBean.setStatus(0);
				getReceiptResponseBean.setMessage("Please enter a valid email");
				return new ResponseEntity<>(getReceiptResponseBean, HttpStatus.BAD_REQUEST);
	
			}
			
			Seat seat = ticketService.getSeatByUser(email);
			
			if(seat == null) {
				getReceiptResponseBean.setStatus(0);
				getReceiptResponseBean.setMessage("No seat is booked for user");
				return new ResponseEntity<>(getReceiptResponseBean, HttpStatus.OK);
			}
			getReceiptResponseBean.setStatus(1);
			getReceiptResponseBean.setMessage("User seat is fetched successfully");
			getReceiptResponseBean.setAmount(20);
			getReceiptResponseBean.setFrom("London");
			getReceiptResponseBean.setTo("France");
			getReceiptResponseBean.setPassenger(u);
			getReceiptResponseBean.setSeat(seat);
		return new ResponseEntity<>(getReceiptResponseBean, HttpStatus.OK);	
		}
		catch (Exception e) {
			getReceiptResponseBean.setStatus(0);
			getReceiptResponseBean.setMessage("Something Went Wrong");
			return new ResponseEntity<>(getReceiptResponseBean, HttpStatus.BAD_REQUEST);
		}
	}
}
