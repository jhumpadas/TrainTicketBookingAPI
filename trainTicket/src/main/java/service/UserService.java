package service;

import dao.UserDAO;
import entity.User;

public class UserService {
	UserDAO userDAO = new UserDAO();
	
	public User getUserByEmail(String email) {
		return userDAO.getUserByEmail(email);
	}
}
