package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertRecordOperationDynamically {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		
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
			System.out.println("employee Id:");
			preparedStatement.setInt(1, Integer.parseInt(br.readLine()));
			System.out.println("employee Name:");
			preparedStatement.setString(2, br.readLine());
			System.out.println("Designation:");
			preparedStatement.setString(3, br.readLine());
			System.out.println("Salary:");
			preparedStatement.setDouble(4, Double.parseDouble(br.readLine()));
			System.out.println("City"); 
			preparedStatement.setString(5, br.readLine());
					
			
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
