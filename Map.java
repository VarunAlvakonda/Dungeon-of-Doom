/**
 * Reads and contains in memory the map of the game.
 *
 */
public class Map {

	/* Representation of the maps */
	private char[][] map;
	private char[][] map2;
	private char[][] map3;

	/* Map names */
	private String mapName;
	private String mapName2; 
	private String mapName3; 


	/* Gold required for the human player to win */
	private int goldRequired;
	private int goldRequired2;
	private int goldRequired3;


	
	/**
	 * Default constructor, creates the default maps "Very small Dungeon of doom".
	 */
	public Map() {
		mapName = "Very small Dungeon of Doom";
		goldRequired = 2;
		map = new char[][]{
		{'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#'},
		{'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#'},
		{'#','#','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','#','#'},
		{'#','#','.','.','.','.','.','.','G','.','.','.','.','.','.','.','.','.','E','.','#','#'},
		{'#','#','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','#','#'},
		{'#','#','.','.','E','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','#','#'},
		{'#','#','.','.','.','.','.','.','.','.','.','.','.','G','.','.','.','.','.','.','#','#'},
		{'#','#','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','#','#'},
		{'#','#','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','#','#'},
		{'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#'},
		{'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#'}
		};
		goldRequired2 = 4;		
		map2 = new char[][]{
		{'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#'},
		{'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#'},
		{'#','#','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','#','#'},
		{'#','#','.','.','.','G','#','#','#','.','.','.','.','.','.','.','.','E','.','.','.','#','#','.','.','#','#'},
		{'#','#','.','.','.','#','#','#','#','.','.','.','.','.','.','.','.','.','.','.','.','#','#','.','.','#','#'},
		{'#','#','.','.','.','.','.','.','.','.','.','.','.','#','#','.','.','.','.','.','.','#','#','.','.','#','#'},
		{'#','#','.','.','.','.','.','.','.','.','.','.','.','#','#','.','.','.','.','.','.','#','#','.','.','#','#'},
		{'#','#','.','.','.','.','.','.','.','.','.','.','.','#','#','.','.','.','.','.','.','#','#','.','.','#','#'},
		{'#','#','.','.','.','#','.','.','#','#','#','#','#','#','#','.','.','.','.','.','.','.','.','.','.','#','#'},
		{'#','#','.','.','.','#','.','G','#','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','#','#'},
		{'#','#','.','.','.','.','#','.','.','#','#','.','.','.','.','.','.','#','#','#','#','.','.','.','.','#','#'},
		{'#','#','.','.','.','.','.','#','G','.','.','#','.','.','.','.','.','#','G','.','.','#','#','#','#','#'},
		{'#','#','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','#','#','#','#','#'},
		{'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#'},
		{'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#'}
		};
	
	}
	/** This is what the program uses to see if the move that the player makes is valid or not
	 * @param playerlocation: This is the index of the player 
	 * @param playerlocation2: This is the index of the player 
	 * @param what_map: The number of the map, either 1,2 or 3.
	 * @return : Successul if @param is valid or Unsuccessful if the @param command is wrong.
	 */
	public String playerPosition2(int playerlocation,int playerlocation2, String what_map) {
		if (what_map.equals("1")){
			if (map[playerlocation][playerlocation2]=='#'){
				return "Unsuccessful";
			}
			else {
				return "Successul";
			}
		}
		else if (what_map.equals("2")){
			if (map2[playerlocation][playerlocation2]=='#'){
				return "Unsuccessful";
			}
			else {
				return "Successul";
			}
		}
		else {
			if (map3[playerlocation][playerlocation2]=='#'){
				return "Unsuccessful";
			}
			else {
				return "Successul";
			}
		}
		
	}
	
	/** This is what the program uses to print the 5x5 grid when the player inputs look for map 1
	 * @param playerlocation: This is the index of the player 
	 * @param playerlocation2: This is the index of the player 
	 * @return : The 5x5 string of the map with the player in the centre
	 */
	public String printMap(int playerlocation,int playerlocation2) {
		char location = map[playerlocation][playerlocation2];
		map[playerlocation][playerlocation2] = 'P';
		String s = "";
		for (int i=playerlocation-2; i < playerlocation + 3; i++) {
			for (int j=playerlocation2-2; j < playerlocation2+3; j++) {
				s += map[i][j];
			}
			 s += "\n";
		}
		map[playerlocation][playerlocation2] = location;
		return s.toString();
	}
	
	/** This is what the program uses to print the 5x5 grid when the player inputs look for map 2
	 * @param playerlocation: This is the index of the player 
	 * @param playerlocation2: This is the index of the player 
	 * @return : The 5x5 string of the map with the player in the centre
	 */
	public String printMap2(int playerlocation,int playerlocation2) {
		char location = map2[playerlocation][playerlocation2];
		map2[playerlocation][playerlocation2] = 'P';
		String s = "";
		for (int i=playerlocation-2; i < playerlocation + 3; i++) {
			for (int j=playerlocation2-2; j < playerlocation2+3; j++) {
				s += map2[i][j];
			}
			 s += "\n";
		}
		map2[playerlocation][playerlocation2] = location;
		return s.toString();
	}
	/*
	public String printMap3(int playerlocation,int playerlocation2) {
		char location = map3[playerlocation][playerlocation2];
		map3[playerlocation][playerlocation2] = 'P';
		String s = "";
		for (int i=playerlocation-2; i < playerlocation + 3; i++) {
			for (int j=playerlocation2-2; j < playerlocation2+3; j++) {
				s += map3[i][j];
			}
			 s += "\n";
		}
		map3[playerlocation][playerlocation2] = location;
		return s.toString();
	}
	*/

    /**
	 * @param what_map: The number of the map, either 1,2 or 3.
     * @return : Gold required to exit the current map.
     */
    public int getGoldRequired(String what_map) {
        if (map.equals("1")){
			return goldRequired;
		}
		else if (map.equals("2")){
			return goldRequired2;
		}
		else{
			return goldRequired3;
		}
    }
}
