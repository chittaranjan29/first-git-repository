package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchInsert {

	public static void main(String[] args) {
	
		Connection conn=null;
		try 
		{
			//Driver class name
			Class.forName("com.mysql.cj.jdbc.Driver"); //Mysql 8
			
			//creating a connection			
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/appdatabase", "root", "root");
			
		
			Statement statement=conn.createStatement();
			
			statement.addBatch("insert into employee values(333,'Tarun','Developer',50000,'Mumbai')");
			statement.addBatch("insert into employee values(444,'Mohan','Designer',40000,'Chennai')");
			
			
			if(statement.executeBatch().length>0)
			{
				System.out.println("Batch insertion successfull!!");
			}
			else
			{
				System.out.println("Batch insertion unsuccessfull!!");
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
