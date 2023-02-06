package package17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Chamber {

	LinkedList<String> chamber = new LinkedList<String>();
	
	
	static LinkedList<Integer> getTopology(ArrayList<String> chamber) {
		
	//Each position starts at 0, at which point any corresponding rock will be stopped
		LinkedList<Integer> topology = new LinkedList<Integer>(
				Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0));
			
		for(int i = 0; i < topology.size(); i++) {
				//Iterates depth until it reaches floor or a fallen rock, then stores the value at the corresponding position on the Array
				for(int depth = 0; depth < chamber.size(); depth++) {
					if((chamber.get(depth)).charAt(i) == '#' 
							|| (chamber.get(depth)).charAt(i) == '-') {
						topology.set(i, depth);
						break;
						}					
					}
				}
			return topology;
	
		}
		
}
