package package17;

import java.util.ArrayList;
import java.util.Arrays;

public class Rock {
	
	ArrayList<String> rock = new ArrayList<String>();
	
	int leftmostPosition;
	
	int rightmostPosition;
	
	
			
			
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
			
		static int heighestRockLayerAtPosition(ArrayList<String> rock, int position) {
			int i = - 1;
			for(i = rock.size() -1; i >= 0; i-- ) {
				if (rock.get(i).charAt(position) == '@') {
					break;
				}
			}		
			return i;
		}
		
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
		
		
		
		
	
}
