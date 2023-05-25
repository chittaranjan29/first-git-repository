package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class ResultSetMetadataExample {

	public static void main(String[] args) {
		Connection conn=null;
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver"); //Mysql 8
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/appdatabase", "root", "root");
			
			conn.setAutoCommit(true);
			
		
			PreparedStatement stmt=conn.prepareStatement("select * from employee");
			ResultSet resultSet=stmt.executeQuery();
			ResultSetMetaData metaData=resultSet.getMetaData();
			
			System.out.println(metaData.getColumnCount());
			System.out.println(metaData.getColumnName(1));
			System.out.println(metaData.getColumnTypeName(2));
			
			conn.commit();
			
		}
		
		
		catch (ClassNotFoundException | SQLException e) {
			
			System.out.println(e.getMessage());
		}
		

	}

}
