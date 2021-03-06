package com.revature.services;

import com.revature.models.CurrentUser;
import com.revature.models.UserCredential;
import com.revature.repositories.UserDAO;

public class UserService {
	UserDAO dao;

	public UserService() {
		this.dao = new UserDAO();
	}

	public CurrentUser validateUser(UserCredential user) {
		CurrentUser currentUser = dao.validatUserAndPassword(user);
		return currentUser;
	}
}
