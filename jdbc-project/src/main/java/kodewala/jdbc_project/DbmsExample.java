package kodewala.jdbc_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbmsExample {
	public static void main(String[] args) throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/27th_oct_batch", "root", "Pro1234$");

		// #read this is for read the data records from the database
//      try {
//		Class.forName("com.mysql.cj.jdbc.Driver");
//	
//		Statement stmt = con.createStatement();
//		String query = "select * from user_info";
//		
//		ResultSet rs = stmt.executeQuery(query);
//		
//		while (rs.next()) {
//			int id = rs.getInt(1);
//			String userName = rs.getString(2);
//			String userID = rs.getString(3);
//			String status = rs.getString(4);
//
//			System.out.println("Id: " + id);
//			System.out.println("User Name: " + userName);
//			System.out.println("User ID: " + userID);
//			System.out.println("Status: " + status);
//		}
//		
//	} catch (ClassNotFoundException e) {
//		e.printStackTrace();
//		
//	}
		// #create this is for create the data records in the database
//      try {
//    	  Class.forName("com.mysql.cj.jdbc.Driver"); 
//    	  Statement stmtcreate = con.createStatement();
//    	  String createquery = "INSERT INTO user_info (id, user_name, user_id, status) VALUES\r\n"
//    	  		+ "(6, 'Santhosh', 'SAN101', 'ACTIVE'),\r\n"
//    	  		+ "(7, 'Naveen', 'NAV102', 'INACTIVE'),\r\n"
//    	  		+ "(8, 'Reddy', 'RED103', 'ACTIVE'),\r\n"
//    	  		+ "(9, 'Kiran', 'KIR104', 'PENDING'),\r\n"
//    	  		+ "(10, 'Ajay', 'AJA105', 'ACTIVE');";
//    	  int rsCreate = stmtcreate.executeUpdate(createquery);
//		
//	} catch (Exception e) {
//		e.printStackTrace();
//	}

		// delete this is for delete a record from the table in the database
//		try {
//			Statement stmtdelete = con.createStatement();
//			String deletequery = "DELETE FROM user_info WHERE id=3";
//			int rsdelete = stmtdelete.executeUpdate(deletequery);
//			System.out.println("Rows deleted: " + rsdelete);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		
		//update this is for update a record in the table
//		try {
//			Statement stmtupdate = con.createStatement();
//			String updatequery = "UPDATE user_info SET user_name='Naveen',user_id='NAV103',status='ACTIVE' WHERE id=4";
//			int rsupdate = stmtupdate.executeUpdate(updatequery); 
//			System.out.println("Rows updated: " + rsupdate);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}
	
}
