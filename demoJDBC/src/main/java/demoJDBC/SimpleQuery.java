package demoJDBC;

//Importing SQL database
import java.sql.*;

//Main class to illustrate demo of JDBC
public class SimpleQuery  {
  
  static String connectionUrl = "jdbc:mysql://localhost:3306/classicmodels";
  static String userName = "root";
  static String userPass = "password";
  static Connection con=null;

  // Main driver method
  public static void main(String[] args) throws Exception
  {

      
      try {
           con = DriverManager.getConnection(connectionUrl, userName,userPass);
      } catch (SQLException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
      }

      // Step 3: Creating statement
      Statement st = con.createStatement();

      // Step 4: Executing the query and storing the
      // result
      ResultSet rs = st.executeQuery(
          " select employeeNumber,lastName,firstName,VacationHours from employees where VacationHours >  20");

      // Step 5: Processing the results
      while (rs.next()) {
    	  String EmployeeID  = rs.getString("employeeNumber");
    	  String lname  = rs.getString("lastName");
          String fname = rs.getString("firstName");
          String vachours  = rs.getString("VacationHours");
          System.out.println(EmployeeID +" | " + lname + "|"+ fname+"|"+vachours );
         // System.out.println("Begin New Record");
         // FILL IN CODE HERE
      }

      // Step 6: Closing the connections
      // using close() method to release memory resources
      con.close();
  
  // Display message for successful execution of program
  System.out.println("JDBC query completed");
  }
}

//end of Code