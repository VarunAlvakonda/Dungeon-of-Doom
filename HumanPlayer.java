import java.util.Scanner;
/**
 * Runs the game with a human player and contains code needed to read inputs.
 *
 */
public class HumanPlayer {
	Main logic = new Main();
	private Scanner userInput;
	private String x; 
	public String[] commands = new String[] {"hello", "gold", "move n", "move s", "move w", "move e", "pickup", "look", "quit"};
	/**
     * A constructor that reads player's input from the console.
     * <p>
     */
    public HumanPlayer() { 
		userInput = new Scanner(System.in);
    }
	/**
	 * Converts the input to lower case to ensure that the commands are accepted in upper case or lower case 
	 * <p>
	 * @return : A string containing the input the player entered.
	 */
	public String playerInput(){
		return (userInput.nextLine()).toLowerCase();
	}
	
    /**
     * Processes the command. It should return a reply in form of a String, as the protocol dictates.
     * Otherwise it should return the string "Invalid".
     *
     * @return : Processed output or Invalid if the @param command is wrong.
     */
	public String getNextAction() {
		String command = playerInput();
		int j = 0;
		String n = "";
		while (j < 9) {
			if (commands[j].equals(command)){
				n = command;
				break;
			}	
			else if (j == 8){
				n = "Invalid";
				break;
			}
			j += 1;
			
		}
		return n;
	}
}