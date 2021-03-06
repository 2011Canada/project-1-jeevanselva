package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.models.CurrentUser;
import com.revature.models.UserCredential;
import com.revature.util.ConnectionFactory;

public class UserDAO {
	ConnectionFactory cf;

	public UserDAO() {
		super();
		this.cf = new ConnectionFactory();
	}

	public CurrentUser validatUserAndPassword(UserCredential user) {
		CurrentUser currentUser = new CurrentUser();
		try {

			Connection newConnection = ConnectionFactory.getNewConnection();
			String sql = "select ers_users.ers_users_id, ers_users.user_first_name,"
					+ " ers_users.user_last_name, ers_user_roles.user_role from"
					+ " ers_users inner join ers_user_roles on ers_users.user_role_id ="
					+ " ers_user_roles.ers_user_role_id where ers_username=? " + "and ers_password = ?;";
			PreparedStatement validateUserStatement = newConnection.prepareStatement(sql);
			validateUserStatement.setString(1, user.getUserName());
			validateUserStatement.setString(2, user.getPassword());
			ResultSet result = validateUserStatement.executeQuery();
			if (result.next()) {

				currentUser.setFirstName(result.getString("user_first_name"));
				currentUser.setLastName(result.getString("user_last_name"));
				currentUser.setUserId(result.getInt("ers_users_id"));
				currentUser.setUserRole(result.getString("user_role"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return currentUser;
	}

}
