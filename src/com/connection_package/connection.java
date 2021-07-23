package com.connection_package;

import java.sql.Connection;
import java.sql.DriverManager;

public class connection {
	static Connection con;

	public static Connection create_connection(){
	try{
	//load the driver
	//Class.forName("com.mysql.jdbc.Driver");
	Class.forName("com.mysql.cj.jdbc.Driver");

	//create the connection
	String user = "root";
	String password = "root";
	String url = "jdbc:mysql://localhost:3306/COVID_Symptom_Tracker?autoReconnect=true&useSSL=false";
	//String url = "jdbc:mysql://localhost/COVID_Symptom_Tracker";

	con = DriverManager.getConnection(url, user, password);

	}catch(Exception e){
	e.printStackTrace();
	}

	return con;
	}

}
