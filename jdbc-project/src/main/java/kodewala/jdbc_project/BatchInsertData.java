package kodewala.jdbc_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class BatchInsertData {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/27th_oct_batch", "root", "Pro1234$");
			
			String sql = "insert into user_info(user_name,user_id,status) values(?,?,?)";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			 
			int batchSize = 50;
			
			for (int i = 0; i < 1000; i++) {
				ps.setString(1, "avinash1"+ i);
				ps.setString(2, "avi@123"+ i);
				ps.setString(3, "CREATED");
				ps.addBatch();
				System.out.println("adding to batch");
				
				if (i % batchSize ==0) {
					System.out.println("executing the batch of " + i);
					ps.executeBatch();
				}
				
//				int result = ps.executeUpdate();
//				System.out.println("record inserted"+ result);
				
			}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}


