package package17;

import java.util.ArrayList;
import java.util.Arrays;


public class Functions {
	
	
	
	ArrayList<String> el = new ArrayList<String>(
					Arrays.asList("|....@..|\r\n", 
								  "|....@..|\r\n", 
								  "|..@@@..|\r\n"));
	
	ArrayList<String> cross = new ArrayList<String>(
			Arrays.asList("|...@...|\r\n",
					  	  "|..@@@..|\r\n",
					      "|...@...|\r\n"));
	
	ArrayList<String> hLine = new ArrayList<String>(
			Arrays.asList("|..@@@@.|"));
	
	ArrayList<String> vLine = new ArrayList<String>(
			Arrays.asList("|..@....|\r\n",
					  	  "|..@....|\r\n",
					  	  "|..@....|\r\n",
						  "|..@....|\r\n"));
	
	ArrayList<String> square = new ArrayList<String>(
			Arrays.asList("|..@@...|\r\n",
						  "|..@@...|\r\n"));
	
	
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
	
	
	
	static void moveRight(ArrayList<String> rock) {
		//Accounts for if the rock is already as far right as can be
		if (getRightmostPosition(rock) == 7) {
			for(int i = 0; i <= rock.size() - 1; i++ ) {
				System.out.println(rock.get(i));
			}
			return;
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
				System.out.println(output.get(i));
			}
			return;
		}
	}
	
	static void moveLeft(ArrayList<String> rock) {
		//Accounts for if the rock is already as far right as can be
		if (getLeftmostPosition(rock) == 1) {
			for(int i = 0; i <= rock.size() - 1; i++ ) {
				System.out.println(rock.get(i));
			}
			return;
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
				System.out.println(output.get(i));
			}
			return;
		}
		
	}
	
	
	
	String moveStraightRockLeft(String input) {
		if(input.charAt(7)=='.') {
			int j = 0;
			for(int i = 8 ; i < 0; i--) {
				if (input.charAt(i)=='@') {
					j = i;
					break;
				}
			
			}
			if(j == 6) {
				return "|...@@@@|";
			}
			else if (j == 5) {
				return "|..@@@@.|";
			}
			else if(j == 4) {
				return "|.@@@@..|";
			}
			else {return "error";}

		}
		else {
			return input;
		}
	}
	
	String moveStraightRockRight(String input) {
		if(input.charAt(1)=='.') {
			int j = 0;
			for(int i = 0 ; i < 8; i++) {
				if (input.charAt(i)=='@') {
					j = i;
					break;
				}
			}
			if(j == 4) {
				return "|..@@@@.|";
			}
			else if(j == 3) {
				return "|.@@@@..|";
			}
			else if(j == 2) {
				return "|@@@@...|";
			}
			else {return "error";}

		}
		else {
			return input;
		}
	}
	
	String steamParser(String directions, String input){
		for(int i = 0; i <= directions.length() - 1; i++) {
			if (directions.charAt(i)=='>'){
				moveStraightRockRight(input);
			}
			else if (directions.charAt(i)=='<') {
				moveStraightRockLeft(input);
			}
			else return "error";
		}
		return input;
		
	}
	
}
