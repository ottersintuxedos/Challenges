package package17;

import java.util.ArrayList;
import java.util.Arrays;

public class Runner {
	
	static void listPrinter(ArrayList<String> input){
		for(int i = 0; i < input.size(); i++ ) {
			System.out.println(input.get(i));
		}
	}
	
	
	public static void main(String[] args) {
		ArrayList<String> hLine = new ArrayList<String>(
				Arrays.asList("|..@@@@.|"));
		
		ArrayList<String> cross = new ArrayList<String>(
				Arrays.asList("|...@...|",
						  	  "|..@@@..|",
						      "|...@...|"));
		
		ArrayList<String> el = new ArrayList<String>(
				Arrays.asList("|....@..|", 
							  "|....@..|", 
							  "|..@@@..|"));

		 ArrayList<String> vLine = new ArrayList<String>(
				Arrays.asList("|..@....|",
						  	  "|..@....|",
						  	  "|..@....|",
							  "|..@....|"));
		
		 ArrayList<String> square = new ArrayList<String>(
				Arrays.asList("|..@@...|",
							  "|..@@...|"));
		
		ArrayList<String> chamber = new ArrayList<String>(
				Arrays.asList("+-------+")
				);
		
		ArrayList<String> chamber1 = new ArrayList<String>(
				Arrays.asList("|..##...|",
							  "|..##...|",
							  "+-------+")
				);
		
	// Functions.moveLeft(square);
		
	// Functions.moveRight(square);
		
	// Functions.moveRight(el);
	
	// Functions.moveLeft(el);
	
	// Functions.moveRight(hLine);
		
	// Functions.moveLeft(hLine);
	
	// Functions.moveRight(vLine);
	
	// Functions.moveLeft(vLine);
	
	// Functions.moveRight(cross);
	
	// Functions.moveLeft(cross);
		
	//	Functions.rockMaker(square, chamber);
		
		
		
	
		
	///	listPrinter(Functions.rockLander(hLine, hLine chamber1));
	
	// listPrinter(Functions.rockSim(">><<<<", vLine));
	
	//System.out.println(Chamber.getTopology(Functions.rockSim(">><<<<", vLine)));
	
	listPrinter(Functions.rockSim(">>>><><><><><><>>>>>>>>>>>><<><", vLine));
		
	//	listPrinter(Functions.moveRight(cross));
	
	}

}
