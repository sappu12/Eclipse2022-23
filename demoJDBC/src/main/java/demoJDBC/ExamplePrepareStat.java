package demoJDBC;


import java.sql.*;
import java.sql.PreparedStatement;

public class ExamplePrepareStat{
   public static void main (String[] args)throws Exception {
//Class.forName("com.mysql.jdbc.Driver");
String url =  "jdbc:mysql://localhost:3306/classicmodels"; 
final String USER = "root";
final String PASS = "password";
Connection conn = DriverManager.getConnection(url, USER,PASS);
String SelectSQL = "select * from employees where employeeNumber = ?";
PreparedStatement mystmt = conn.prepareStatement(SelectSQL);
mystmt.setInt(1, 1002);
     ResultSet result = mystmt.executeQuery();
while(result.next())
	            {
	            	String name = result.getString("firstName");
	            	String email  = result.getString("email");
	            	System.out.println(name +" | " + email);
	            }
}
}

