package jdbc_practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetData {

	public void gettingData() {
		String url = "jdbc:mysql://localhost:3306/cci?user=root&password=root";
		String query = "select * from jdbc";

		try {
			Connection connection = DriverManager.getConnection(url);
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet executeQuery = preparedStatement.executeQuery();
			System.out.println(
					executeQuery.getMetaData().getColumnName(1) + "   " + executeQuery.getMetaData().getColumnName(2)
							+ "   " + executeQuery.getMetaData().getColumnName(3));
			while (executeQuery.next()) {
				for (int i = 1; i <= executeQuery.getMetaData().getColumnCount(); i++) {
					if (i > 1) {
						System.out.print("  ");
					} else {
						System.out.println();
					}
					System.out.print(executeQuery.getString(i));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		GetData data = new GetData();
		data.gettingData();
	}

}
