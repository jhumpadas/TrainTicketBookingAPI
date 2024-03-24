package dao;

import java.util.ArrayList;
import java.util.List;

import entity.User;

public class UserDAO {
	List<User> userList = new ArrayList<>();
	
	public void addUser(User u) {
		userList.add(u);
	}
	
	public User getUserByEmail(String email) {
		for(User user : userList) {
			if(user.getEmail().equals(email))
				return user;
		}
		return null;
	}
}
