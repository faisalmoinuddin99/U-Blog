package com.upgrad.ublog.dao;

import com.upgrad.ublog.dto.UserDTO;
import com.upgrad.ublog.db.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * TODO: 6.5. Implement the UserDAO interface and implement this class using the Singleton pattern.
 *  (Hint: Should have a private no-arg Constructor, a private static instance attribute of type
 *  UserDAOImpl and a public static getInstance() method which returns the instance attribute.)
 * TODO: 6.6. findByEmail() method should take email id as an input parameter and
 *  return the user details corresponding to the email id from the UBLOG_USERS table defined
 *  in the database. (Hint: You should get the connection using the DatabaseConnection class)
 * TODO: 6.7. create() method should take user details as input and insert these details
 *  into the UBLOG_USERS table. Return the same UserDTO object which was passed as an input
 *  argument. (Hint: You should get the connection using the DatabaseConnection class)
 */

public class UserDAOImpl implements UserDAO  {
    private static UserDAOImpl instance;

    private UserDAOImpl () {}

    public static UserDAOImpl getInstance() {
        if (instance == null) {
            instance = new UserDAOImpl();
        }
        return instance;
    }

    public static void main(String[] args) {
		try {
			UserDAO userDAO = new UserDAOImpl();
			UserDTO temp = new UserDTO();
			temp.setUserId(1);
			temp.setEmailId("temp@temp.temp");
			temp.setPassword("temp");
			userDAO.create(temp);
			System.out.println(userDAO.findByEmail("temp@temp.temp"));
		} catch (Exception e) {
			System.out.println("FAILED");
		}

		 // Following should be the desired output of the main method.
//		  UserDTO{userId=11, emailId='temp@temp.temp', password='temp'};
	}

    @Override
    public UserDTO findByEmail(String emailId) throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        Statement statement = connection.createStatement();
        String sql = "SELECT * FROM  UBLOG_USERS WHERE email_id = " + emailId;
        ResultSet resultSet = statement.executeQuery(sql);

        if ( resultSet != null && resultSet.next()) {
            UserDTO user = new UserDTO();
            user.setUserId(resultSet.getInt("Id"));
            user.setEmailId(resultSet.getString("email_id"));
            user.setPassword(resultSet.getString("password"));

            return user;
        } else {
            return null;
        }
    }

    @Override
    public UserDTO create(UserDTO userDTO) throws SQLException {
//        Connection connection = DatabaseConnection.getConnection();
//        Statement statement = connection.createStatement();
//        String sql = "INSERT INTO UBLOG_USERS(email_id, password) VALUES (" +
//                userDTO.getUserId() + ", '" +
//                userDTO.getEmailId() + ", '" +
//                userDTO.getPassword() + "', " +
//                ")";
//        statement.executeUpdate(sql);
//        return userDTO;
//    }
        return null;
    }



}
