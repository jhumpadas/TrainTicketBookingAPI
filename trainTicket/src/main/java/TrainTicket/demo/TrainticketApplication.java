package TrainTicket.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import dao.TicketDAO;
import dao.UserDAO;
import entity.Seat;
import entity.User;

@SpringBootApplication
public class TrainticketApplication {

	public static void main(String[] args) {
		//SpringApplication.run(TrainticketApplication.class, args);
		//Here I am adding demo data for seat and user
		TicketDAO  ticketDAO = new TicketDAO();
		
		UserDAO userDAO = new UserDAO();
		userDAO.addUser(new User(101,"Ram","Gupta","ram.gupta@gmail.com",false));
		userDAO.addUser(new User(102,"Shyam","Gupta","shyam.gupta@gmail.com",false));
		userDAO.addUser(new User(103,"Ankit","Gupta","ankit.gupta@gmail.com",false));
		
		ticketDAO.addSeatA(new Seat(1,true,"A"));
		ticketDAO.addSeatA(new Seat(2,true,"A"));
		ticketDAO.addSeatB(new Seat(1,true,"B"));
		ticketDAO.addSeatB(new Seat(2,true,"B"));
		ticketDAO.addSeatA(new Seat(3,true,"A"));
		
		
	}

}
