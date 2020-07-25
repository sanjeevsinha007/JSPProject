package com.sanjeev.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sanjeev.model.User;


public class UserDAO {
	private String jdbcURL="jdbc:mysql://localhost:3306/employee?useSSL=false";
	private String jdbcUsername="root";
	private String jdbcPassword="root";
	
	
	private static final String insertUserSql = "Insert into users(username, email, country) values(?,?,?)";
	private static final String deleteUserSql = "Delete from users where id=?";
	private static final String updateUserSql = "Update users set username=?, email=?, country=? where id=?";
	private static final String selectUserSql = "Select * from users where id=?";
	private static final String selectAllUserSql = "select * from users";
	
	public Connection getConnection() throws ClassNotFoundException
	{
		Connection conn=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
			
		}catch(SQLException ex)
		{
			System.out.println("Exception Caught");
			System.out.println(ex.getMessage());
		}
		
		return conn;
		
	}
	
	public void insertUser(User user) throws SQLException, ClassNotFoundException {
		try {
		Connection conn = getConnection();
		conn=getConnection();
		PreparedStatement stmt=conn.prepareStatement(insertUserSql);
		stmt.setString(1, user.getName());
		stmt.setString(2, user.getEmail());
		stmt.setString(3, user.getCountry());
		stmt.executeUpdate();
		conn.close();
		}catch(SQLException ex)
		{
			printSQLException(ex);
		}
		
	}
	
	private void printSQLException(SQLException ex) {
		for (Throwable e:ex)
		{
			if (e instanceof SQLException)
			{
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t=ex.getCause();
				while(t!=null)
				{
					System.out.println("Cause : " +  t);
					t.getCause();
				}
			}
		}
		
	}

	public boolean updateUser(User user) throws SQLException, ClassNotFoundException {
		boolean result;
		try {
		Connection conn = getConnection();
		conn=getConnection();
		PreparedStatement stmt=conn.prepareStatement(updateUserSql);
		stmt.setString(1, user.getName());
		stmt.setString(2, user.getEmail());
		stmt.setString(3, user.getCountry());
		stmt.setInt(4, user.getId());
		result=stmt.executeUpdate()>0;
		conn.close();
		
		}catch(SQLException ex)
		{
			printSQLException(ex);
			result=false;
		}
		return result;
	}
	
	public boolean deleteUser(int id) throws SQLException, ClassNotFoundException {
		boolean result;
		try {
		Connection conn = getConnection();
		conn=getConnection();
		PreparedStatement stmt=conn.prepareStatement(deleteUserSql);
		stmt.setInt(1, id);
		result=stmt.executeUpdate() >0;
		conn.close();
		}catch(SQLException ex)
		{
			printSQLException(ex);
			result=false;
		}
		return result;
	}
	
	public User selectUser(int id) throws SQLException, ClassNotFoundException {
		User user=new User();
		try {
		Connection conn = getConnection();
		conn=getConnection();
		PreparedStatement stmt=conn.prepareStatement(selectUserSql);
		stmt.setInt(1, id);
		ResultSet result=stmt.executeQuery();
		
		while(result.next())
		{
			user.setId(result.getInt(1));
			user.setName(result.getString(2));
			user.setEmail(result.getString(3));
			user.setCountry(result.getString(4));
			
		}
		conn.close();
		}catch(SQLException ex)
		{
			printSQLException(ex);
		}
		return user;
		
		
	}
	
	public List<User> selectAllUser() throws SQLException, ClassNotFoundException {

		List<User> userList=new ArrayList<User>();
		try {
		Connection conn = getConnection();
		conn=getConnection();
		PreparedStatement stmt=conn.prepareStatement(selectAllUserSql);
		ResultSet result=stmt.executeQuery();
		while(result.next())
		{
			User user=new User();
			user.setId(result.getInt(1));
			user.setName(result.getString(2));
			user.setEmail(result.getString(3));
			user.setCountry(result.getString(4));
			userList.add(user);
		}
		conn.close();
		conn.close();
		}catch(SQLException ex)
		{
			printSQLException(ex);
		}
		return userList;
	}
}
