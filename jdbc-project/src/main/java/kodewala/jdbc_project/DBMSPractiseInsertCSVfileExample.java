package kodewala.jdbc_project;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DBMSPractiseInsertCSVfileExample {
	InputStream is = getClass().getClassLoader().getResourceAsStream("customer.csv");
	BufferedReader br = new BufferedReader(new InputStreamReader(is));

	String line;

	public static void main(String[] args) {

		try {
			InputStream is = DBMSPractiseInsertCSVfileExample.class.getClassLoader()
					.getResourceAsStream("customerdata.csv");

			BufferedReader br = new BufferedReader(new InputStreamReader(is));

			String line;
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/27th_oct_batch", "root",
					"Pro1234$");
			
			String CustomerData = "insert into customer_info(customer_id,first_name,last_name,email,phone,city,age,signup_date,status) values(?,?,?,?,?,?,?,?,?)"; 
			PreparedStatement ps = con.prepareStatement(CustomerData);
			
			String InValidCustomerData = "insert into customer_info_invalid(customer_id,first_name,last_name,email,phone,city,age,signup_date,status) values(?,?,?,?,?,?,?,?,?)"; 
			PreparedStatement ps1 = con.prepareStatement(InValidCustomerData);
			int batchSize = 100;
			
			br.readLine(); 
			while ((line = br.readLine()) != null) {
				System.out.println("This is start reading");
				
				String[] data = line.split(",");
				String id = data[0].trim();
				String firstname = data[1].trim();
				String lastname = data[2].trim();
				String email = data[3].trim();
				String phone = data[4].trim();
				String city = data[5].trim();
				String age = data[6].trim();
				String signup_date = data[7].trim();
				String status = data[8].trim();
				
				System.out.println("id :" +id);
				System.out.println("fisrtname :" +firstname);
				System.out.println("lastname :" +lastname);
				System.out.println("email :" +email);
				System.out.println("phone :" +phone);
				System.out.println("city " +city);
				System.out.println("age " +age);
				System.out.println("signup_date :" +signup_date);
				System.out.println("status :" +status);
				try {
					
				
					boolean isValid = true;

					if(id == null || id.trim().isEmpty() || !id.matches("\\d+")){
					    ps1.setNull(1, java.sql.Types.INTEGER);
					}else{
					    ps1.setInt(1, Integer.parseInt(id));
					}
					if(firstname == null || firstname.trim().isEmpty()) {
					    System.out.println("Invalid firstname");
					    isValid = false;
					}

					if(lastname == null || lastname.trim().isEmpty()) {
					    System.out.println("Invalid lastname");
					    isValid = false;
					}

					if(email == null || !email.contains("@")) {
					    System.out.println("Invalid email");
					    isValid = false;
					}

					if(phone == null || !phone.matches("\\d+")) {
					    System.out.println("Invalid phone");
					    isValid = false;
					}

					if(age == null || age.trim().isEmpty() || !age.matches("\\d+")){
					    ps1.setNull(7, java.sql.Types.INTEGER);
					}else{
					    ps1.setInt(7, Integer.parseInt(age));
					}
					if(signup_date == null || signup_date.trim().isEmpty()){
					    ps1.setNull(8, java.sql.Types.DATE);
					}else{
					    ps1.setDate(8, java.sql.Date.valueOf(signup_date));
					}
					if(status == null || status.trim().isEmpty()) {
					    System.out.println("Invalid status");
					    isValid = false;
					}
					for (int i = 0; i < 1000; i++) {
						if(isValid && i % batchSize ==0){

						    ps.setInt(1, Integer.parseInt(id));
						    ps.setString(2, firstname);
						    ps.setString(3, lastname);
						    ps.setString(4, email);
						    ps.setString(5, phone);
						    ps.setString(6, city);
						    ps.setInt(7, Integer.parseInt(age));
						    ps.setString(8, signup_date);
						    ps.setString(9, status);
						    ps.executeUpdate();

						}else{

						    ps1.setString(1, id);
						    ps1.setString(2, firstname);
						    ps1.setString(3, lastname);
						    ps1.setString(4, email);
						    ps1.setString(5, phone);
						    ps1.setString(6, city);
						    ps1.setString(7, age);
						    ps1.setString(8, signup_date);
						    ps1.setString(9, status);

						    ps1.executeUpdate();

						}	
					}
					
				
				} catch (Exception e) {
					e.printStackTrace();
				}
			
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
