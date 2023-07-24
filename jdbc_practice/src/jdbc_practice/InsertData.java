package jdbc_practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertData {
	public static void insert(Student student) {
		String url = "jdbc:mysql://localhost:3306/cci?user=root&password=root";
		String query = "insert into jdbc values('"+student.getId()+"','"+student.getName()+"','"+student.getEmailid()+"')";

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url);
			preparedStatement = connection.prepareStatement(query);
			int executeUpdate = preparedStatement.executeUpdate();
			System.out.println(executeUpdate);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} catch (Exception e2) {
				System.out.println(e2);
			}
		}

	}
}
