package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateRecordOperation {

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
			
			PreparedStatement preparedStatement=conn.prepareStatement("update employee set designation=? , salary=? where id=?");//? indicates placeholders
			
			preparedStatement.setString(1, "Senior Developer");
			preparedStatement.setDouble(2, 80000);
			preparedStatement.setInt(3, 4545);
					
			
			preparedStatement.execute();
			
			System.out.println("Record updated!!");
			
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


