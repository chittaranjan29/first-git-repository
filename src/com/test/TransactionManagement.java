package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;

public class TransactionManagement {

	public static void main(String[] args) {
		Connection conn=null;
		try 
		{

			Class.forName("com.mysql.cj.jdbc.Driver"); 
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");
			conn.setAutoCommit(false);	//setting autocommit to false
			
			if(conn!=null)
			{
				System.out.println("Connection established");
			}
			else
			{
				System.out.println("Connection failed");
			}
			
			
			
			//statement 1
			PreparedStatement ps=conn.prepareStatement("insert into employees values(?,?,?,?)");
			ps.setInt(1, 25);
			ps.setString(2, "Karthik@gmail.com");
			ps.setString(3, "Karthik");
			ps.setString(4, "Kumar");
			
			
			Savepoint s1=conn.setSavepoint("s1");
			ps.executeUpdate();
			//statement 1
			PreparedStatement ps1=conn.prepareStatement("insert into employees values(?,?,?,?)");
			ps.setInt(1, 24);
			ps.setString(2, "Karthik@gmail.com");
			ps.setString(3, "Karthik");
			ps.setString(4, "Kumar");
			
			Savepoint s2=conn.setSavepoint("s1");
		
			
			ps.executeUpdate();
			
			conn.rollback(s1);
			
			
			conn.commit();
			System.out.println("Transaction commited!!");
			
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
