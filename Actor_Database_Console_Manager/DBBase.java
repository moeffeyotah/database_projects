import java.sql.*;
import java.util.*;
import java.util.function.Function;

/**
 * Database basic control functions
 */
public class DBBase
{

	private String dataBaseName;

	public DBBase(String dataBaseName)
	{
		this.dataBaseName = dataBaseName;
	}

	/**
	 * Connect to the database
	 */
	protected Connection connect()
	{
		String url = String.format("jdbc:sqlite:src/%s", dataBaseName);

		Connection conn = null;
		try
		{
			conn = DriverManager.getConnection(url);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}

		return conn;
	}

	/**
	 * Delete a row from a table with a simple condition
	 */
	public <T> Integer deleteRowSimple(String tableName, String fieldName, T fieldValue)
	{
		String param;
		if (fieldValue instanceof Integer)
		{
			param = String.format("%s = %d", fieldName, fieldValue);
		}
		else
		{
			// String
			param = String.format("%s = '%s'", fieldName, fieldValue);
		}

		String sqlQuery = "DELETE FROM %s WHERE %s";
		try
		{
			Connection conn = this.connect();
			Statement stmt = conn.createStatement();
			int result = stmt.executeUpdate(String.format(sqlQuery, tableName, param));
			return result;

		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * Delete rows from a table with two simple conditions
	 */
	public <T, U> int deleteRowsSimple(String tableName, String fieldName1, T fieldValue1, String fieldName2,
			U fieldValue2)
	{
		String param1, param2;
		if (fieldValue1 instanceof Integer)
		{
			param1 = String.format("%s = %d", fieldName1, fieldValue1);
		}
		else
		{
			// String
			param1 = String.format("%s = '%s'", fieldName1, fieldValue1);
		}
		if (fieldValue2 instanceof Integer)
		{
			param2 = String.format("%s = %d", fieldName2, fieldValue2);
		}
		else
		{
			// String
			param2 = String.format("%s = '%s'", fieldName2, fieldValue2);
		}
		String sqlQuery = "DELETE FROM %s WHERE %s AND %s";
		try
		{
			Connection conn = this.connect();
			Statement stmt = conn.createStatement();
			String sqlQueryResult = String.format(sqlQuery, tableName, param1, param2);
			int result = stmt.executeUpdate(sqlQueryResult);
			return result;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * Select all rows from a table
	 * @param tableName table name
	 * @param parseFunc A function to parse each ResultSet row into a String
	 * @return all rows with designated format
	 */
	public List<String> selectAll(String tableName, Function<ResultSet, String> parseFunc)
	{
		String sqlQuery = "SELECT * FROM %s";
		Connection conn = this.connect();
		List<String> result = new ArrayList<String>();
		try
		{
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(String.format(sqlQuery, tableName));

			while (rs.next())
			{
				String parseResult = parseFunc.apply(rs);
				result.add(parseResult);
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * Select specific field list from a table
	 * @param tableName table name
	 * @param fieldName field name
	 * @param parseFunc A function to parse each ResultSet row into designated type
	 * @return all selected field values with designated type
	 */
	public <T> List<T> selectField(String tableName, String fieldName, Function<ResultSet, T> parseFunc)
	{
		String sqlQuery = "SELECT %s FROM %s";
		Connection conn = this.connect();
		List<T> result = new ArrayList<T>();
		try
		{
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(String.format(sqlQuery, fieldName, tableName));

			while (rs.next())
			{
				T parseResult = parseFunc.apply(rs);
				result.add(parseResult);
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return result;
	}

}
