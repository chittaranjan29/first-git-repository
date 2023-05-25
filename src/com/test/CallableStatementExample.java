package com.test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.Callable;

public class CallableStatementExample {

	public static void main(String[] args) {
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_app_db", "root", "root");
			CallableStatement statement=conn.prepareCall("{call getAllEmployeeData()}");
			ResultSet result=  statement.executeQuery();
			
			while(result.next())
			{
				System.out.println(result.getInt(1)+ " "+result.getString(2)+" "+result.getString(3)+" "+result.getDouble(4));
			}
			
		} catch (ClassNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
