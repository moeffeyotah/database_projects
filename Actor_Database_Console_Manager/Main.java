
import java.util.Scanner;

/**
 * Project Entrance
 * 
 * Author: Moses Effeyotah & Longfei Li (Marvin)
 * Date: 02-11-2025 
 * Course: INFO-6120 DataBase
 * Project part 1
 */
public class Main
{

	private static BehaviorController behaviorCtrl;
	private static Scanner scanner;

	/**
	 * Main Entrance
	 */
	public static void main(String[] args)
	{
		behaviorCtrl = new BehaviorController();

		boolean running = true;
		while (running)
		{
			String command = getCommandFromTerminal("Enter a command:");
			if (command.length() == 0)
				continue;
			if (command.equals("EXIT"))
			{
				running = false;
				/** Session is End */
			}
			else
			{
				behaviorCtrl.parseCommand(command);
			}
		}
	}

	/**
	 * Public Input Tools
	 * @param Message hint message
	 * @return Upper case input letters
	 */
	public static String getCommandFromTerminal(String message)
	{
		if (scanner == null)
			scanner = new Scanner(System.in);

		System.out.println(message);
		String command;
		command = scanner.nextLine();
		command = command.trim();
		command = command.toUpperCase();
		return command;
	}

}
