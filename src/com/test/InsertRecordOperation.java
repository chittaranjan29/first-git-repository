package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertRecordOperation {

	public static void main(String[] args) {
		
		
		Connection conn=null;
		try 
		{
			//Driver class name
			Class.forName("com.mysql.cj.jdbc.Driver"); //Mysql 8
			
			//creating a connection
			
			
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/appdatabase", "root", "root");
			
			
			if(conn!=null)
			{
				System.out.println("Connection established");
			}
			else
			{
				System.out.println("Connection failed");
			}
			
			PreparedStatement preparedStatement=conn.prepareStatement("INSERT INTO EMPLOYEE VALUES(?,?,?,?,?)");
			preparedStatement.setInt(1, 4545);
			preparedStatement.setString(2, "Arun");
			preparedStatement.setString(3, "Developer");
			preparedStatement.setDouble(4, 60000);
			preparedStatement.setString(5, "Delhi");
					
			
			if(preparedStatement.executeUpdate()==1)
			{
				System.out.println("Record inserted!!");
			}
			else
			{
				System.out.println("Error in execution!!");
			}
		} 
		
		catch (ClassNotFoundException | SQLException e) {
			
			System.out.println(e.getMessage());
		}
		
		finally
		{
			//closing connection
			try
			{
				conn.close();
			} 
			catch (SQLException e) {


				System.out.println(e.getMessage());
			}
		}

	}

}
