/**
 * Contains the main logic part of the game, as it processes.
 *
 */
public class Main {
	private boolean isGameRunning = true;
	public Map map = new Map();
	public static Map map2 = new Map();
	private static int gold_owned = 0;
	private static int playerlocation;
	private static int playerlocation2;

	/**
	 * Default constructor
	 */
	public Main() {
	}
	
    /**
	 * Returns the gold required to win.
	 * @param what_map: The number of the map, either 1,2 or 3. 
     * @return : Gold required to win.
     */
    private String hello(String what_map) {
      return "Gold to win: " + map.getGoldRequired(what_map);
    }
	
	/**
	 * Returns the gold currently owned by the player.
	 *
     * @return : Gold currently owned.
     */
    protected String gold() {
        return "Gold Owned: " + gold_owned;
    }

    /**
     * Checks if movement is legal and updates player's location on the map.
     *
     * @param direction : The direction of the movement.
	 * @param what_map: The number of the map, either 1,2 or 3.
     * @return : Protocol if success or not.
     */
    private String move(String direction, String what_map) {
		if (direction.equals("move n")) {
			playerlocation += -1;
			if (map2.playerPosition2(playerlocation,playerlocation2,what_map).equals("Unsuccessful")){
				playerlocation += 1;
				return "Unsuccessful";
			}
			else {
				return"Successful";
			}
		}
		else if (direction.equals("move s")) {
			playerlocation += 1;
			if (map2.playerPosition2(playerlocation,playerlocation2,what_map).equals("Unsuccessful")){
				playerlocation += -1;					
				return "Unsuccessful";
			}
			else {
				return "Successful";
			}
		}
		else if (direction.equals("move w")) {
			playerlocation2 += -1;
			if (map2.playerPosition2(playerlocation,playerlocation2,what_map).equals("Unsuccessful")){
				playerlocation2 += 1;
				return "Unsuccessful";
			}
			else {
				return "Successful";
			}
		}
		else {
			playerlocation2 += 1;
			if (map2.playerPosition2(playerlocation,playerlocation2,what_map).equals("Unsuccessful")){
				playerlocation2 += -1;
				return "Unsuccessful";
			}
			else {
				return "Successful";
			}
		}			
    }

    /**
     * Converts the map from a 2D char array to a single string.
     * @param what_map: The number of the map, either 1,2 or 3.
     * @return : A String representation of the game map.
     */
    public String look(String what_map) {
		if (what_map.equals("1")){
			return map.printMap(playerlocation,playerlocation2);
		}
		else if (what_map.equals("2")){
			return map.printMap2(playerlocation,playerlocation2);
		}
		else {
			return "1";
		}
    }

    /**
     * Processes the player's pickup command, updating the map and the player's gold amount.
     * @param what_map: The number of the map, either 1,2 or 3.
     * @return If the player successfully picked-up gold or not.
     */
    private String pickup(String what_map) {
		if (what_map.equals("1")){
			if ((playerlocation == 3 && playerlocation2 == 8)||((playerlocation == 6 && playerlocation2 == 13))) {
				gold_owned+=1;
				return("SUCCESS. Gold owned: " + gold_owned);
			}
			else {
				return("FAIL");
			}
		}
		else if (what_map.equals("2")){
			if ((playerlocation == 3 && playerlocation2 == 5)||((playerlocation == 9 && playerlocation2 == 7)) ||((playerlocation == 11 && playerlocation2 == 8))) {
				gold_owned+=1;
				return("SUCCESS. Gold owned: " + gold_owned);
			}
			else {
				return("FAIL");
			}
		}
		return null;
	}
    /**
     * Quits the game, shutting down the application.
	 * @param what_map: The number of the map, either 1,2 or 3.
	 * @return : Depends on whether the player is on the exit tile, and has enough gold. Either returns Win, Lose or Unsuccessful.
     */
    private String quitGame() {
		if (((playerlocation == 3 && playerlocation2 == 18) || (playerlocation == 5 && playerlocation2 == 4)) && gold_owned ==2) {
			return ("Win");
		}	
		else if (((playerlocation == 3 && playerlocation2 == 18) || (playerlocation == 5 && playerlocation2 == 4)) && gold_owned !=2){
			return ("Lose");
		}
		else {
			return ("Unsuccessful");
		}
		
    }
	
	public static void main(String[] args) {
		Main logic = new Main();
		HumanPlayer player = new HumanPlayer();
		Map map = new Map();
		String what_map;
		what_map = player.playerInput();
		while (true) {
			playerlocation = (int)(Math.random() * ((9 - 1) + 1)) + 1;
			playerlocation2 = (int)(Math.random() * ((20 - 2) + 2)) + 1;
			if (map.playerPosition2(playerlocation,playerlocation2,what_map).equals('#')){
				playerlocation = (int)(Math.random() * ((9 - 1) + 1)) + 1;
				playerlocation2 = (int)(Math.random() * ((20 - 2) + 2)) + 1;
			}
			else {
				break;
			}
		}
		while (true) {
			String command = player.getNextAction();
			if (command.equals("quit")){
				System.out.println(logic.quitGame());
				break;
			}
			else if (command.equals("pickup")){
				System.out.println(logic.pickup(what_map));
			}
			else if (command.equals("hello")){
				System.out.println(logic.hello(what_map));
			}
			else if (command.equals("move n")) {
				System.out.println(logic.move(command,what_map));
			}
			else if (command.equals("move s")) {
				System.out.println(logic.move(command,what_map));
			}
			else if (command.equals("move w")) {
				System.out.println(logic.move(command,what_map));
			}
			else if (command.equals("move e")) {
				System.out.println(logic.move(command,what_map));
			}	
			else if (command.equals("gold")) {
				System.out.println(logic.gold());
			}
			else if (command.equals("look")){
				System.out.println(logic.look(what_map));
			}
			else {
				System.out.println("Invalid");
			}
			
			
		}
		
    }
}