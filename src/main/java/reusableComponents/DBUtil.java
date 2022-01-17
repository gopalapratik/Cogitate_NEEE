package reusableComponents;

import static org.testng.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DBUtil {

	static Connection con = null;
	static Statement stmt;
	// public static void main(String[] args) throws ClassNotFoundException {
	// SQLException {

	public DBUtil() {
		/*try {
			//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}*/
		try {
			con = DriverManager.getConnection(PropertiesOperations.getPropertyValueByKey("dbConnectionString"),
					PropertiesOperations.getPropertyValueByKey("dbUserName"),
					PropertiesOperations.getPropertyValueByKey("dbPassword"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String getResultFromDB(String query,String requiredField) throws ClassNotFoundException, SQLException {

		ResultSet rs = stmt.executeQuery(query);
		String getResult = null;
		while (rs.next()) {
			getResult = rs.getString(requiredField);
			System.out.println(getResult);
		}
		return getResult;
	}
	
	public List<String> getResultFromDBAsList(String query, String requiredField) throws ClassNotFoundException, SQLException {

		ResultSet rs = stmt.executeQuery(query);
		List<String> getResult = new ArrayList<>();
		while (rs.next()) {
			getResult.add(rs.getString(requiredField));
		}
		System.out.println(getResult);
		return getResult;
	}
	
	public Map<String, String> getResultFromDBAsMap(String query, String mapKey,String requiredField) throws ClassNotFoundException, SQLException {

		ResultSet rs = stmt.executeQuery(query);
		Map<String,String> getResult = new LinkedHashMap<>();
		while (rs.next()) {
			getResult.put(rs.getString(mapKey.trim()),rs.getString(requiredField.trim()));
		}
		
		return getResult;
	}

	public void insertDataInTable(String query) throws SQLException, InterruptedException {

		int rec = stmt.executeUpdate(query);
		System.out.println(rec);
		assertEquals(rec, 1);
		Thread.sleep(15000);
	}
}
