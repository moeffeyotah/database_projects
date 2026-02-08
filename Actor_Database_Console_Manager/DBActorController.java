import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.function.Function;

/**
 * Database Table "Actor" Controller
 */
public final class DBActorController extends DBBase
{

	public DBActorController(String dataBaseName)
	{
		super(dataBaseName);
	}

	/**
	 * Get Current Local Date and Time
	 * 
	 * @return String dd-MM-yyyy HH:mm:ss
	 */
	private String getLocalDateTime()
	{
		LocalDateTime myDateObj = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String formattedDate = myDateObj.format(myFormatObj);
		return formattedDate;
	}

	/**
	 * Insert a new row into Actor table
	 */
	public void insertRow(int ID, String firstName, String lastName)
	{

		String sqlQuery = "INSERT INTO %s (actor_id, first_name, last_name, last_update)" + "VALUES (?, ?, ?, ?)";

		try
		{
			Connection conn = this.connect();
			PreparedStatement stmt = conn.prepareStatement(String.format(sqlQuery, TableName.Actor));
			stmt.setInt(1, ID);
			stmt.setString(2, firstName);
			stmt.setString(3, lastName);
			stmt.setString(4, getLocalDateTime());
			int result = stmt.executeUpdate();
			if (result == 1)
				System.out.println(String.format("Add a new record succeed. ID = %d", ID));
			else
				System.out.println("Add a new record faild.");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Update a row in Actor table
	 * (Backup function, no calls have been made yet)
	 */
	public void updateRow(String tableName, int ID, String firstName, String lastName)
	{
		String sqlQuery = "UPDATE %s SET first_name = ?, last_name = ?, last_update = ? WHERE actor_id = ?";

		try
		{
			Connection conn = this.connect();
			PreparedStatement stmt = conn.prepareStatement(String.format(sqlQuery, tableName));
			stmt.setString(1, firstName);
			stmt.setString(2, lastName);
			stmt.setString(3, getLocalDateTime());
			stmt.setInt(4, ID);
			int result = stmt.executeUpdate();
			if (result > 0)
				System.out.println("Update succeed.");
			else
				System.out.println("Update faild.");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Delete a row from Actor table
	 */
	public void deleteRow(String firstName, String lastName)
	{
		int result = super.deleteRowsSimple(TableName.Actor, "first_name", firstName, "last_name", lastName);
		if (result > 0)
			System.out.println("Delete succeed.");
		else
			System.out.println("Delete faild.");
	}

	/**
	 * List all rows from Actor table
	 */
	public List<String> selectAll()
	{
		String outputFormat = "%d    %s %s";
		return super.selectAll(TableName.Actor, rs -> {
			try
			{
				return String.format(outputFormat, rs.getInt(1), rs.getString(2), rs.getString(3));
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
			return outputFormat;
		});
	}

	/**
	 * Select specific field list from Actor table
	 */
	public List<Integer> selectField(String fieldName)
	{
		Function<ResultSet, Integer> parseSelecFieldResult = rs -> {
			int result = 0;
			try
			{
				result = rs.getInt(1);
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
			return result;
		};
		return super.selectField(TableName.Actor, fieldName, parseSelecFieldResult);
	}

}
