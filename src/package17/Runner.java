package package17;

import java.util.ArrayList;
import java.util.Arrays;

public class Runner {
	
	public static void main(String[] args) {
		ArrayList<String> el = new ArrayList<String>(
				Arrays.asList("|..@....|", 
							  "|..@....|", 
							  "|@@@....|"));

	ArrayList<String> cross = new ArrayList<String>(
			Arrays.asList("|...@...|",
					  	  "|..@@@..|",
					      "|...@...|"));
	
	ArrayList<String> hLine = new ArrayList<String>(
			Arrays.asList("|..@@@@@|"));
	
	ArrayList<String> vLine = new ArrayList<String>(
			Arrays.asList("|..@....|",
					  	  "|..@....|",
					  	  "|..@....|",
						  "|..@....|"));
	
	ArrayList<String> square = new ArrayList<String>(
			Arrays.asList("|.....@@|",
						  "|.....@@|"));
		
		
	// Functions.moveLeft(square);
		
	// Functions.moveRight(square);
		
	// Functions.moveRight(el);
	
	// Functions.moveLeft(el);
	
	// Functions.moveRight(hLine);
		
	// Functions.moveLeft(hLine);
	
	// Functions.moveRight(vLine);
	
	// Functions.moveLeft(vLine);
	
	Functions.moveRight(cross);
	
	Functions.moveLeft(cross);
	
	}

}
