package com.feifei.Dao;

import java.sql.*;

public class DBconnection {
  private static final String URL="jdbc:mysql://localhost:3306/phone?characterEncoding=utf8";
  private static final String USER="root";
  private static final String PWD="1234";
 
  
  static {
	  try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
  
  public static Connection getConnection() {
	 Connection connection=null;
	  try {
		connection=DriverManager.getConnection(URL, USER, PWD);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return connection;
	  
  }
  
  
  public static void getclose(Connection connection,PreparedStatement preparedStatement,ResultSet resultSet) {
	  try {
		if(resultSet!=null)
			  resultSet.close();
		  if(preparedStatement!=null)
			  preparedStatement.close();
		  if(connection!=null)
			  connection.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
  
  
  
  
  
  
  
  
  
  
}
