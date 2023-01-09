package demoJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatementParameterExample {
	Connection connection = null;
	String driverName = "com.mysql.jdbc.Driver";
	String connectionUrl = "jdbc:mysql://localhost:3306/classicmodels";
	String userName = "root";
	String userPass = "password";

	public Connection getConnection() {
		try {
			connection = DriverManager.getConnection(connectionUrl, userName, userPass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	public static void main(String[] args) throws SQLException {
		PreparedStatementParameterExample ptmtExample = new PreparedStatementParameterExample();
		Connection con = ptmtExample.getConnection();
		ResultSet resultSet = null;
		// Writing a parameterised query in prepared Statement
		String insertQuery = "INSERT INTO student(RollNo,Name,Course,Address) VALUES(?,?,?,?)";
		try {
			// Compiling query String
			PreparedStatement statement = con.prepareStatement(insertQuery);
			// setting parameter to the query
			statement.setInt(1, 0001);
			statement.setString(2, "SWAPNA");
			statement.setString(3, "FULLSTACKJAVA");
			statement.setString(4, "PA");
			PreparedStatement statement1 = con.prepareStatement(insertQuery);
			statement1.setInt(1, 0002);
			statement1.setString(2, "BINDU");
			statement1.setString(3, "FULLSTACKJAVA");
			statement1.setString(4, "TX");
			PreparedStatement statement2 = con.prepareStatement(insertQuery);
			statement2.setInt(1, 0003);
			statement2.setString(2, "SUNITHA");
			statement2.setString(3, "FULLSTACKJAVA");
			statement2.setString(4, "FL");
			System.out.println("Inserted into student");
			int affectedRows = statement.executeUpdate();
			//System.out.println(affectedRows + " row(s) affected !!");
			int affectedRows1 = statement1.executeUpdate();
			//System.out.println(affectedRows1 + " row(s) affected !!");
			int affectedRows2 = statement2.executeUpdate();
			System.out.println(affectedRows+affectedRows1+affectedRows2 + " row(s) affected !!");
			
			// display result
						resultSet = statement.executeQuery(" select * from student");

						// Step 5: Processing the results
						while (resultSet.next()) {
							String RollNo = resultSet.getString("RollNo");
							String name = resultSet.getString("Name");
							String course = resultSet.getString("Course");
							String address = resultSet.getString("Address");
							System.out.println(RollNo + " | " + name + "|" + course + "|" + address);
							// System.out.println("Begin New Record");
							// FILL IN CODE HERE
						}
			
			// Updating Query
						System.out.println("Updating record with rollNo 1 to 47");		
			String sql = "update student set RollNo=?  where Name = ?";

			statement = con.prepareStatement(sql);
			statement.setInt(1, 47);
			statement.setString(2, "SWAPNA");

			int rowsAffected = statement.executeUpdate();
			
			System.out.println(rowsAffected + " row(s) affected !!");

			// Deleting a row
			System.out.println("Deleting record with rollNo 3");
			String sqldel = "delete from student where RollNo = ?";

			statement = con.prepareStatement(sqldel);
			statement.setInt(1, 3);
			int rowsAffected2 = statement.executeUpdate();

			System.out.println(rowsAffected2 + " row(s) affected !!");

			// display result
			System.out.println("Final records in table");
			resultSet = statement.executeQuery(" select RollNo,Name,Course,Address from student");

			// Step 5: Processing the results
			while (resultSet.next()) {
				String RollNo = resultSet.getString("RollNo");
				String name = resultSet.getString("Name");
				String course = resultSet.getString("Course");
				String address = resultSet.getString("Address");
				System.out.println(RollNo + " | " + name + "|" + course + "|" + address);
				// System.out.println("Begin New Record");
				// FILL IN CODE HERE
			}

			statement.close();
			statement1.close();
			statement2.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			con.close();
		}
	}
}