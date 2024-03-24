package dao;

import java.util.ArrayList;
import java.util.List;

import entity.Seat;

public class TicketDAO {
	List<Seat> seatsA = new ArrayList<>();
	List<Seat> seatsB = new ArrayList<>();
	
	public void addSeatA(Seat s) {
		seatsA.add(s);
	}
	public void addSeatB(Seat s) {
		seatsB.add(s);
	}
	public Seat getSeatA() {
		Seat ans = null ;
		for(Seat s: seatsA) {
			if(s.isEmpty()) {
				ans = s;
				break;
			}
				
		}
		return ans;
		
	}
	public Seat getSeatB() {
		Seat ans = null ;
		for(Seat s: seatsB) {
			if(s.isEmpty()) {
				ans = s;
				break;
			}
		}
		return ans;
	}
	public List<Seat> getSeatAList(){
		return this.seatsA;
	}
	public List<Seat> getSeatBList(){
		return this.seatsB;
	}
}
