import java.util.List;

/**
 * Analysis and Parse User's behavior
 */
public class BehaviorController
{

	private static DBActorController dbCtrl;

	public BehaviorController()
	{
		dbCtrl = new DBActorController("sakila.db");
	}

	/**
	 * Parse the input command
	 * 
	 * @param cmd
	 * @return
	 */
	public Boolean parseCommand(String cmd)
	{
		switch (cmd)
		{
		case "ADD":
			add();
			return true;
		case "REMOVE":
			remove();
			return true;
		case "LIST":
			list();
			return true;
		default:
			/**
			 * If none of the above commands are entered, output an error message to the
			 * console and start the loop again.
			 */
			System.out.println("Invalid command.");
			return false;
		}
	}

	/**
	 * ADD - Prompt the user to enter a first and last name - add the actor to the
	 * actor table
	 */
	public void add()
	{
		List<Integer> listIds = dbCtrl.selectField("actor_id");
		int lastId = 1;
		if (listIds.size() > 0)
		{
			listIds.sort((a, b) -> b - a);
			lastId = listIds.getFirst();
		}
		String firstName = Main.getCommandFromTerminal("Please input first name:");
		String lastName = Main.getCommandFromTerminal("Please input last name:");

		dbCtrl.insertRow(lastId + 1, firstName, lastName);
	}

	/**
	 * REMOVE - Prompt the user to enter a first and last name. Then remove any
	 * actors in the actor table that have the supplied first and last name
	 */
	public void remove()
	{
		String firstName = Main.getCommandFromTerminal("Please input first name:");
		String lastName = Main.getCommandFromTerminal("Please input last name:");

		dbCtrl.deleteRow(firstName, lastName);
	}

	/**
	 * LIST - list all the actors currently in the database
	 */
	public void list()
	{

		List<String> listResult = dbCtrl.selectAll();
		for (int i = 0; i < listResult.size(); i++)
		{
			String resultLine = listResult.get(i);
			System.out.println(resultLine);
		}

	}

}
