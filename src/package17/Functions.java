package package17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;


public class Functions {
	
	static int getLeftmost(String shape) {
		return shape.indexOf('@');
	};
	
	static int getRightmost(String shape) {
		return shape.lastIndexOf('@');
	};
	
	
//	static int getLeftmostPosition(ArrayList<String> shape) {
//		int value = 9;
//		for(int i = 0; i <= shape.size() - 1; i++ ) {
//			for(int j = 1; j <= 7; j++) {
//				if (shape.get(i).charAt(j) =='@' && j < value) {
//					value = j;
//					break;
//				};
//		
//			}
//		}
//		return value;
//	};
	
	
	
//	static int getRightmostPosition(ArrayList<String> shape) {
//		int value = 0;
//		for(int i = 0; i <= shape.size() - 1; i++ ) {
//			for(int j = 7; j >= 0; j--) {
//				if (shape.get(i).charAt(j) =='@' && j > value) {
//					value = j;
//					break;
//				};
//		
//			}
//		}
//		return value;
//	};

	
	
	//Returns an ArrayList which represents how deep each position is 
//	static LinkedList<Integer> getTopology(ArrayList<String> chamber) {
//		
//		//Each position starts at 0, at which point any corresponding rock will be stopped
//		LinkedList<Integer> topology = new LinkedList<Integer>(
//				Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0));
//			
//		for(int i = 0; i < topology.size(); i++) {
//				//Iterates depth until it reaches floor or a fallen rock, then stores the value at the corresponding position on the Array
//				for(int depth = 0; depth < chamber.size(); depth++) {
//					if((chamber.get(depth)).charAt(i) == '#' 
//							|| (chamber.get(depth)).charAt(i) == '-') {
//						topology.set(i, depth);
//						System.out.println("break");
//						break;
//						}					
//					}
//				}
//			return topology;
//	
//		}

		
	
	
//	//If the ArrayList passed into this method doesn't contain an '@' this method will return -1
//	static int heighestRockLayerAtPosition(ArrayList<String> rock, int position) {
//		int i = - 1;
//		for(i = rock.size() -1; i >= 0; i-- ) {
//			if (rock.get(i).charAt(position) == '@') {
//				break;
//			}
//		}		
//		return i;
//	}

	
//	static ArrayList<String> getNextRock(ArrayList<String> previousRock){
//		ArrayList<String> el = new ArrayList<String>(
//				Arrays.asList("|....@..|", 
//							  "|....@..|", 
//							  "|..@@@..|"));
//
//		ArrayList<String> cross = new ArrayList<String>(
//				Arrays.asList("|...@...|",
//						  	  "|..@@@..|",
//						      "|...@...|"));
//
//		ArrayList<String> hLine = new ArrayList<String>(
//				Arrays.asList("|..@@@@.|"));
//
//		 ArrayList<String> vLine = new ArrayList<String>(
//				Arrays.asList("|..@....|",
//						  	  "|..@....|",
//						  	  "|..@....|",
//							  "|..@....|"));
//		
//		 ArrayList<String> square = new ArrayList<String>(
//				Arrays.asList("|..@@...|",
//							  "|..@@...|"));
//		
//		ArrayList<String> nextRock = new ArrayList<String>();
//		if(previousRock.equals(hLine)) {
//			nextRock = cross;
//		}
//		else if(previousRock.equals(cross)) {
//			nextRock = el;
//		}
//		else if(previousRock.equals(el)) {
//			nextRock = vLine;
//		}
//		else if(previousRock.equals(vLine)) {
//			nextRock = square;
//		}
//		else if(previousRock.equals(square)) {
//			nextRock = hLine;
//		}
//		return nextRock;
//	}
		
	static ArrayList<String> moveRight(ArrayList<String> rock) {
		//Accounts for if the rock is already as far right as can be
		if (Rock.getRightmostPosition(rock) == 7) {
			for(int i = 0; i <= rock.size() - 1; i++ ) {
				
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
		if (Rock.getLeftmostPosition(rock) == 1) {
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
			
	static ArrayList<String> steamParser(String directions, ArrayList<String> input){
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
		
		ArrayList<String> nextRock = new ArrayList<String>(Rock.getNextRock(previousRock));
		
		ArrayList<String> spacing = new ArrayList<String>(
				Arrays.asList("|.......|",
							  "|.......|",
							  "|.......|"));
		
		output.addAll(nextRock);
		output.addAll(spacing);
		output.addAll(chamber);
		
		
		for(int i = 0; i <= output.size() - 1; i++ ) {
			//System.out.println(output.get(i));
		}
		return output;
		
	}
	
	static ArrayList<String> rockLander(ArrayList<String> rock, ArrayList<String> chamber){
		ArrayList<String> output = new ArrayList<String>();
		
		
		// Layers
		for(int i = 0; i < rock.size() ; i++ ) {
			String layer = rock.get(i);
			StringBuilder layerParser = new StringBuilder(layer);
			
		// I know this could be simplified a bit	
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
		int leftPoint = Rock.getLeftmostPosition(rock);
		int rightPoint = Rock.getRightmostPosition(rock);
		
		int depth = chamber.size();
		
		ArrayList<Integer> topology = new ArrayList<Integer>(Chamber.getTopology(chamber));
		
		//Calculates the smallest depth the rock will be able to fall of the positions between its length and assigns it to space
		for(int position = leftPoint; position <= rightPoint; position++) {
			int space = topology.get(position) + Rock.heighestRockLayerAtPosition(rock, position);
			
			if(space < depth) {
				depth = space;
				}
			
		}
			//Temporarily increases the size of the cavern by the size of the rock to be added
		LinkedList<String> outcome = new LinkedList<String>();
				for (int rockLayer = 0; rockLayer <= rock.size(); rockLayer ++) {
					outcome.add("|.......|");
				}
					outcome.addAll(chamber);
					
					
					
				// If the depth is greater than 0, then we start that much further down on the outcome
				for(int layer = depth; layer < depth + rock.size(); layer++) {
					StringBuilder layerMaker = new StringBuilder(outcome.get(layer));
					
					
					
						
						
						for(int position = leftPoint; position <= rightPoint; position++) {
							
							
							if(outcome.get(layer).charAt(position) == '.' 
									&& rock.get(layer - depth).charAt(position) == '@') {
								
									layerMaker.setCharAt(position, '#');
							}
							outcome.set(layer, layerMaker.toString());
						}
					}
				
				
				for (int layer = 0; layer < outcome.size(); layer++) {
					if(outcome.get(layer) == "|.......|") {
					outcome.remove();}
				}
				
				
				
			ArrayList<String> newChamber= new ArrayList<String>();
			newChamber.addAll(outcome);
			return newChamber;	
		}
			
	static ArrayList<String> rockSim(String directions, ArrayList<String> firstRock){
		ArrayList<String> chamber = new ArrayList<String>(
				Arrays.asList("+-------+")
				);
		
		ArrayList<String> currentRock = firstRock;
	//	rockMaker(currentRock, chamber);
		
		ArrayList<String> currentType = currentRock;
		
		for(int i = 0; i <= directions.length() - 1; i++) {

			
			if (directions.charAt(i) =='>'){
				currentRock = moveRight(currentRock);
			}
			if (directions.charAt(i)=='<') {
				currentRock = moveLeft(currentRock);
			}
			
			if(i % 3 == 2) {
				
				chamber = fitter(currentRock, chamber);
				currentRock = Rock.getNextRock(currentType);
		
			}
		}
		
		return chamber;	
	}
	
	
	
	
}
