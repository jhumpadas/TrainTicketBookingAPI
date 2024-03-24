package controller;

import RequestBean.GetTicketRequestBean;
import RequestBean.ModifySeatRequestBean;
import ResponseBean.GetTicketResponseBean;
import ResponseBean.ModifySeatResponseBean;
import ResponseBean.RemoveUserFromTrainResponseBean;
import entity.Seat;
import entity.User;
import service.TicketService;
import service.UserService;

@RestController
public class purchaseTicketController {
	// Initializing with 100 seats at each section. Seats will have section either"A" or "B"
	int secACapacity = 100;
	int secBCapacity = 100;
	TicketService ticketService = new TicketService();
	UserService userService = new UserService();

	//This API is for point number 1
	@RequestMapping("/purchaseNewTicket")
	public ResponseEntity<> getTicket(@RequestBody GetTicketRequestBean getTicketRequestBean) {
		GetTicketResponseBean getTicketResponseBean = new GetTicketResponseBean();
		User user = null;
		Seat seat = null;

		try {
			user = getTicketRequestBean.getUser();
			
			//When user purchases ticket, I am trying to assign  the user in section A first if section
			//A is full then trying to assign to section B
			
			if (secACapacity < 100) {
				seat = ticketService.getSeatFromA();
				secACapacity++;

			} else if (secACapacity < 100) {
				seat = ticketService.getSeatFromB();
				secBCapacity++;
			}

			else {
				getTicketResponseBean.setStatus(0);
				getTicketResponseBean.setErrMessage("No seat Available");
				return new ResponseEntity<>(getTicketResponseBean, HttpStatus.OK);
			}
			user.setHasBookedTicket(true);
			seat.setPassenger(user);
			seat.setEmpty(false);

			getTicketResponseBean.setStatus(1);
			getTicketResponseBean.setAmountPaid(20);
			getTicketResponseBean.setFrom("London");
			getTicketResponseBean.setTo("France");
			getTicketResponseBean.setSeatNo(seat.getSeatNo());
			getTicketResponseBean.setPassenger(user);
			getTicketResponseBean.setMessage("Seat Allocated Successfully");
			return new ResponseEntity<>(getTicketResponseBean, HttpStatus.OK);

		} catch (Exception e) {
			getTicketResponseBean.setStatus(0);
			getTicketResponseBean.setErrMessage("Something Went Wrong");
			return new ResponseEntity<>(getTicketResponseBean, HttpStatus.BAD_REQUEST);
		}
	}

	
	//This API is for point number 8
	@PostMappping("/removeUserFromTrain")
	public ResponseEntity<> removeUser(@RequestBody User user) {
		
		RemoveUserFromTrainResponseBean removeUserFromTrainResponseBean = new RemoveUserFromTrainResponseBean();
		try {
			if (!user.isHasBookedTicket()) {
				removeUserFromTrainResponseBean.setStatus(0);
				removeUserFromTrainResponseBean.setMessage("User has not booked any seat");
				return new ResponseEntity<>(removeUserFromTrainResponseBean, HttpStatus.OK);
			}
			Seat seat = ticketService.getSeatByUser(user.getEmail());
			seat.setEmpty(true);
			seat.setPassenger(null);
			if (seat.getSection().equals("A"))
				secACapacity--;
			else
				secBCapacity--;

			user.setHasBookedTicket(false);
			removeUserFromTrainResponseBean.setStatus(1);
			removeUserFromTrainResponseBean.setMessage("User has been removed from train");
			return new ResponseEntity<>(removeUserFromTrainResponseBean, HttpStatus.OK);
		} catch (Exception e) {
			removeUserFromTrainResponseBean.setStatus(0);
			removeUserFromTrainResponseBean.setMessage("Something Went Wrong");
			return new ResponseEntity<>(removeUserFromTrainResponseBean, HttpStatus.BAD_REQUEST);
		}
	}
	
	//This API is for point number 9
	@PostMapping("/modifySeatForUser")
	public ResponseEntity<> modifySeat( @RequestBody ModifySeatRequestBean modifySeatRequestBean){
		ModifySeatResponseBean modifySeatResponseBean = new ModifySeatResponseBean();
		
		//Here if the user is in section A , I am moving it to section B and vice versa
		
		try {
			String userEmail = modifySeatRequestBean.getUserEmail();
			Seat oldSeat = modifySeatRequestBean.getSeat();
			String sec = seat.getSection();
			if(sec.equals("A")) {
				Seat newAllocatedSeat = ticketService.getSeatFromB();
				if(newAllocatedSeat !=null) {
				oldSeat.setEmpty(true); //Marking the old seat as empty
				oldSeat.setPassenger(null); //Removing the user from the old seat
				secACapacity--; //Increamenting the capacity of older section
				newAllocatedSeat.setEmpty(false); //Marking the new seat as occupied
				User u = userService.getUserByEmail(userEmail);
				newAllocatedSeat.setPassenger(u); //Adding the passenger to the new seat
				secBCapacity++; //decreamenting the other section's capacity
			}
				else {
					modifySeatResponseBean.setStatus(0);
					modifySeatResponseBean.setMessage("No seat available from other section");
					return new ResponseEntity<>(modifySeatResponseBean, HttpStatus.OK);
				}
			}
			else {
				Seat newAllocatedSeat = ticketService.getSeatFromA();
				if(newAllocatedSeat !=null) {
				oldSeat.setEmpty(true);
				oldSeat.setPassenger(null);
				secBCapacity--;
				newAllocatedSeat.setEmpty(false);
				User u = userService.getUserByEmail(userEmail);
				newAllocatedSeat.setPassenger(u);
				secACapacity++;
			}
				else {
					modifySeatResponseBean.setStatus(0);
					modifySeatResponseBean.setMessage("No seat available from other section");
					return new ResponseEntity<>(modifySeatResponseBean, HttpStatus.OK);
				}
			}
			modifySeatResponseBean.setStatus(1);
			modifySeatResponseBean.setMessage("Seat modified successfully for user" + userEmail);
			return new ResponseEntity<>(modifySeatResponseBean, HttpStatus.OK);

		}
		catch (Exception e) {
			modifySeatResponseBean.setStatus(0);
			modifySeatResponseBean.setMessage("Something Went Wrong");
			return new ResponseEntity<>(modifySeatResponseBean, HttpStatus.BAD_REQUEST);

		}
	}
}
