package controller;

import java.util.ArrayList;
import java.util.List;

import ResponseBean.GetUserAndSeatResponseBean;
import entity.Seat;
import service.TicketService;

@RestController
public class GetUserAndSeatController {
	TicketService ticketService = new TicketService();

	//This API is for point number 7
	@GetMapping("/getSeatAndUserBySection/{section}")
	public ResponseEntity<> getSeatAndUserBySection(@PathVariable String section){
		GetUserAndSeatResponseBean getUserAndSeatResponseBean = new GetUserAndSeatResponseBean();
		List<Seat> bookedSeat = new ArrayList<>();
		try {
			List<Seat> seats = section.equals("A")?ticketService.getSeatAList():ticketService.getSeatBList();
			if(seats.size() == 0) {
				getUserAndSeatResponseBean.setStatus(0);
				getUserAndSeatResponseBean.setMessage("All seats are empty in the section "+section);
				return new ResponseEntity<>(getUserAndSeatResponseBean, HttpStatus.OK);
			}
			
			//I am adding only occupied seats in response bean as seat will contain users also if is is not empty
			for(Seat s : seats) {
				if(!s.isEmpty())
					bookedSeat.add(s);
			}
			getUserAndSeatResponseBean.setStatus(1);
			getUserAndSeatResponseBean.setMessage("Successfully fetched seat and user details for section "+section);
			getUserAndSeatResponseBean.setUserSeatdetails(bookedSeat);
			return new ResponseEntity<>(getUserAndSeatResponseBean, HttpStatus.OK);
			
		}catch (Exception e) {
			getTicketResponseBean.setStatus(0);
			getTicketResponseBean.setErrMessage("Something Went Wrong");
			return new ResponseEntity<>(getTicketResponseBean, HttpStatus.BAD_REQUEST);
		}
	}
}
