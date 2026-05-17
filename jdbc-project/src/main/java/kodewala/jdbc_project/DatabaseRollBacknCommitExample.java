package kodewala.jdbc_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseRollBacknCommitExample {

	public void doFundTransfer(String from, String to, int amount) {
		Connection con = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/27th_oct_batch", "root", "Pro1234$");

			con.setAutoCommit(false);
			String balancequery = "select amount from balance where user_id=?";
			PreparedStatement ps = con.prepareStatement(balancequery);
			ps.setString(1, from);

			ResultSet rs = ps.executeQuery();
			int fromBalance = 0;
			while (rs.next()) {
				fromBalance = rs.getInt(1);

			}
			int newBalance = fromBalance - amount;
			// DEBIT
			String query = "update balance set amount =? where user_id=?";
			ps = con.prepareStatement(query);
			ps.setInt(1, newBalance);
			ps.setString(2, from);
			int recordsUpdated = ps.executeUpdate();
			if (recordsUpdated > 0) {
				System.out.println("Amount " + amount + "Has been deducted from user" + from);
			}

			// CREDIT
			ps = con.prepareStatement(balancequery);
			ps.setString(1, to);

			rs = ps.executeQuery();
			int toBalance = 0;
			while (rs.next()) {
				toBalance = rs.getInt(1);

			}
			newBalance = toBalance + amount;
//		String name = null;
//		name.length();

			ps = con.prepareStatement(query);
			ps.setInt(1, newBalance);
			ps.setString(2, to);

			recordsUpdated = ps.executeUpdate();
			if (recordsUpdated > 0) {
				System.out.println("Amount " + amount + "has been credited to user" + to);
			}
			con.commit();
		} catch (Exception e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			System.out.println("Execption " + e.getMessage());
			e.printStackTrace();

		}

	}
}
