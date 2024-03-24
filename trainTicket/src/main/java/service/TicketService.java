package service;

import java.util.List;

import dao.TicketDAO;
import entity.Seat;
import entity.User;

public class TicketService {
	TicketDAO  ticketDAO = new TicketDAO();

	public Seat getSeatFromA() {
	Seat seat = ticketDAO.getSeatA();
		return seat;
	}
	public Seat getSeatFromB() {
		Seat seat = ticketDAO.getSeatB();
			return seat;
		}
	
	public Seat getSeatByUser(String email) {
		List<Seat> seatsA = ticketDAO.getSeatAList();
		for(Seat s : seatsA) {
			if(!s.isEmpty() && s.getPassenger().getEmail().equals(email))
				return s;
		}
		List<Seat> seatsB = ticketDAO.getSeatBList();
		for(Seat s : seatsB) {
			if(!s.isEmpty() && s.getPassenger().getEmail().equals(email))
				return s;
		}
		
		return null;
		
	}
	public List<Seat> getSeatAList(){
		return ticketDAO.getSeatAList();
	}
	public List<Seat> getSeatBList(){
		return ticketDAO.getSeatBList();
	}
}
