package package17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;


public class Functions {
	
	
	
	
	
	static int getLeftmostPosition(ArrayList<String> shape) {
		int value = 9;
		for(int i = 0; i <= shape.size() - 1; i++ ) {
			for(int j = 1; j <= 7; j++) {
				if (shape.get(i).charAt(j) =='@' && j < value) {
					value = j;
					break;
				};
		
			}
		}
		return value;
	};
	
	static int getLeftmost(String shape) {
		return shape.indexOf('@');
	};
	
	static int getRightmostPosition(ArrayList<String> shape) {
		int value = 0;
		for(int i = 0; i <= shape.size() - 1; i++ ) {
			for(int j = 7; j >= 0; j--) {
				if (shape.get(i).charAt(j) =='@' && j > value) {
					value = j;
					break;
				};
		
			}
		}
		return value;
	};
	
	static int getRightmost(String shape) {
		return shape.lastIndexOf('@');
	};
	
	//Returns an ArrayList which represents how deep each position is 
	static LinkedList<Integer> getTopology(ArrayList<String> chamber) {
		
		//Each position starts at 0, at which point any corresponding rock will be stopped
		LinkedList<Integer> topology = new LinkedList<Integer>(
				Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0));
			
		for(int i = 0; i < topology.size(); i++) {
				
				for(int depth = 0; depth < chamber.size(); depth++) {
					if((chamber.get(depth)).charAt(i) == '#' || (chamber.get(depth)).charAt(i) == '-') {
						topology.set(i, depth);
						System.out.println("break");
						break;
					}
							
				}
			}

			
			return topology;
	
		}
		
		
		
	
	
	//If the ArrayList passed into this method doesn't contain an '@' this method will return -1
	static int lowestRockLayerAtPosition(ArrayList<String> rock, int position) {
		int i = - 1;
		for(i = rock.size() -1; i >= 0; i-- ) {
			if (rock.get(i).charAt(position) == '@') {
				break;
			}
		}		
		return i;
	}
	
	static ArrayList<String> getNextRock(ArrayList<String> previousRock){
		ArrayList<String> el = new ArrayList<String>(
				Arrays.asList("|....@..|", 
							  "|....@..|", 
							  "|..@@@..|"));

		ArrayList<String> cross = new ArrayList<String>(
				Arrays.asList("|...@...|",
						  	  "|..@@@..|",
						      "|...@...|"));

		ArrayList<String> hLine = new ArrayList<String>(
				Arrays.asList("|..@@@@.|"));

		 ArrayList<String> vLine = new ArrayList<String>(
				Arrays.asList("|..@....|",
						  	  "|..@....|",
						  	  "|..@....|",
							  "|..@....|"));
		
		 ArrayList<String> square = new ArrayList<String>(
				Arrays.asList("|..@@...|",
							  "|..@@...|"));
		
		ArrayList<String> nextRock = new ArrayList<String>();
		if(previousRock.equals(hLine)) {
			nextRock = cross;
		}
		else if(previousRock.equals(cross)) {
			nextRock = el;
		}
		else if(previousRock.equals(el)) {
			nextRock = vLine;
		}
		else if(previousRock.equals(vLine)) {
			nextRock = square;
		}
		else if(previousRock.equals(square)) {
			nextRock = hLine;
		}
		return nextRock;
	}
			
	static ArrayList<String> moveRight(ArrayList<String> rock) {
		//Accounts for if the rock is already as far right as can be
		if (getRightmostPosition(rock) == 7) {
			for(int i = 0; i <= rock.size() - 1; i++ ) {
				System.out.println(rock.get(i));
			}
			return rock;
		}
		else {
			ArrayList<String> output = new ArrayList<String>();
			for(int i = 0; i <= rock.size() - 1; i++ ) {
				//Strings are immutable so I have to build a new one using a StringBuilder
				
				StringBuilder outcome= new StringBuilder(rock.get(i));
				
				// This builder makes this new string by setting the leftmost '@' to a '.'		
				outcome.setCharAt(rock.get(i).indexOf('@'), '.');
				
				//and the first '.' after the rightmost '@' to a '@'
				outcome.setCharAt(rock.get(i).lastIndexOf('@') + 1, '@');
				
				output.add(outcome.toString());
				
			}
			for(int i = 0; i <= output.size() - 1; i++ ) {
				//System.out.println(output.get(i));
			}
			return output;
		}
	}
	
	static ArrayList<String> moveLeft(ArrayList<String> rock) {
		//Accounts for if the rock is already as far right as can be
		if (getLeftmostPosition(rock) == 1) {
			for(int i = 0; i <= rock.size() - 1; i++ ) {
				//System.out.println(rock.get(i));
			}
			return rock;
		}
		else {
			ArrayList<String> output = new ArrayList<String>();
			for(int i = 0; i <= rock.size() - 1; i++ ) {
				//Strings are immutable so I have to build a new one using a StringBuilder

				StringBuilder outcome= new StringBuilder(rock.get(i));
				
				// This builder makes this new string by setting the rightmost '@' to a '.'		
				outcome.setCharAt(rock.get(i).lastIndexOf('@'), '.');
				
				//and the first '.' after the leftmost '@' to a '@'
				outcome.setCharAt(rock.get(i).indexOf('@') - 1, '@');
				
				
				output.add(outcome.toString());
				
			}
			for(int i = 0; i <= output.size() - 1; i++ ) {
				//System.out.println(output.get(i));
			}
			return output;
		}
		
	}
			
	ArrayList<String> steamParser(String directions, ArrayList<String> input){
		for(int i = 0; i <= directions.length() - 1; i++) {
			if (directions.charAt(i)=='>'){
				moveRight(input);
			}
			else if (directions.charAt(i)=='<') {
				moveLeft(input);
			}
			
		}
		return input;
		
	}
	
	static ArrayList<String> rockMaker(ArrayList<String> previousRock, ArrayList<String> chamber){
		
		ArrayList<String> output = new ArrayList<String>();
		
		ArrayList<String> nextRock = new ArrayList<String>(getNextRock(previousRock));
		
		ArrayList<String> spacing = new ArrayList<String>(
				Arrays.asList("|.......|",
							  "|.......|",
							  "|.......|"));
		
		output.addAll(nextRock);
		output.addAll(spacing);
		output.addAll(chamber);
		
		
		for(int i = 0; i <= output.size() - 1; i++ ) {
			System.out.println(output.get(i));
		}
		return output;
		
	}
	
	static ArrayList<String> rockLander(ArrayList<String> rock, ArrayList<String> chamber){
		ArrayList<String> output = new ArrayList<String>();
		
		for(int i = 0; i < rock.size() ; i++ ) {
			String layer = rock.get(i);
			StringBuilder layerParser = new StringBuilder(layer);
			
		//I know this could be simplified a bit	
			for(int j = 0; j < layer.length(); j++ ) {
				if(layer.charAt(j) == '@') {
					layerParser.setCharAt(j, '#');
					}
			}
			layer = layerParser.toString();
			output.add(layer);
		}
		output.addAll(chamber);
		return output;
	}
	
	static ArrayList<String> fitter(ArrayList<String> rock, ArrayList<String> chamber) {
		int leftPoint = getLeftmostPosition(rock);
		int rightPoint = getRightmostPosition(rock);
		
//		int lowPointR = lowestLayerAtPosition(rock, rightPoint);
//		int lowPointL = lowestLayerAtPosition(rock, leftPoint);

		ArrayList<Integer> topology = new ArrayList<Integer>(getTopology(chamber));
		
		
		int depth = 0;
		return chamber;
		
		
			
		}
			
			
		
	
	
	
	static ArrayList<String> rockSim(String directions, ArrayList<String> firstRock){
		ArrayList<String> chamber = new ArrayList<String>(
				Arrays.asList("+-------+")
				);
		
		ArrayList<String> currentRock = firstRock;
		ArrayList<String> currentType = currentRock;
		
		for(int i = 0; i <= directions.length() - 1; i++) {

			
			if (directions.charAt(i) =='>'){
				currentRock = moveRight(currentRock);
			}
			if (directions.charAt(i)=='<') {
				currentRock = moveLeft(currentRock);
			}
			
			if(i % 3 == 2) {

				chamber = rockLander(currentRock, chamber);
				currentRock = getNextRock(currentType);
		
			}
		}
		
		return chamber;	
	}
	
	
	
	
}
