package com.test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class CallableStatement2 {

	public static void main(String[] args) {
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_app_db", "root", "root");
			CallableStatement statement=conn.prepareCall("{?= call simpleInterestCalculator(?,?,?)}");
			
			statement.registerOutParameter(1, Types.DOUBLE);
			statement.setDouble(2, 9000);
			statement.setInt(3, 7);
			statement.setInt(4, 6);
			
			ResultSet result=  statement.executeQuery();
			
			while(result.next())
			{
				System.out.println(result.getDouble(1));
			}
			
		} catch (ClassNotFoundException e) 
		{
		
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}
