package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDatabaseCode {

	public static void main(String args[])
	{
		Connection conn=null;
		try 
		{
			//Driver class name
			Class.forName("com.mysql.cj.jdbc.Driver"); //Mysql 8
			
			//creating a connection
			
			
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb", "root", "root");
			
			
			if(conn!=null)
			{
				System.out.println("Connection established");
			}
			else
			{
				System.out.println("Connection failed");
			}
			
			//creating statement instance
			Statement statement=conn.createStatement();
			
			
			//creating new db
			
		
			if(statement.executeUpdate("create database StudentInfoDB3")==1)
			{
				System.out.println("Database created successfuly!!");
			}
			else
			{
				System.out.println("Error in database creation!!");
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
