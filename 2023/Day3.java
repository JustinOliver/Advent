import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

class Day3 {
	
	static Character[][] inputs;
	static ArrayList<ArrayList<Character>> input;
	static int rows = 0;
	static int sum = 0;

	public static void main(String[] args){
		BufferedReader reader;
		String fileName = "Day3Input.txt";
		input = new ArrayList<>();
		int total = 0;


		try {
			reader = new BufferedReader(new FileReader(fileName));
			String line = reader.readLine();

			while(line != null){
				rows++;
				ArrayList<Character> temp = new ArrayList<>();
				for(int i = 0; i < line.length(); i++){
					temp.add(line.charAt(i));
				}
				input.add(temp);

				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e){
			e.printStackTrace();
		}

		int start = 0;
		int end = 0;
		int tempNumber = 1;

		inputs = new Character[input.size()][];

		int i = 0;
		for(ArrayList<Character> c: input){
			inputs[i++] = c.toArray(new Character[c.size()]);
		}

		for(int row = 0; row < inputs.length; row++){
			for(int column = 0; column < inputs[row].length; column++){
				if(Character.isDigit(inputs[row][column])){
					start = column;
					end = column;
					tempNumber = inputs[row][column] - '0';
					column++;
					while(column < inputs[row].length && Character.isDigit(inputs[row][column])){
						tempNumber = tempNumber * 10 + inputs[row][column] - '0';
						column++;
						end++;
					}
				}
				if(isValidPart(start, end, row, column)){
					total += tempNumber;
				}
				start = 0;
				end = 0;
				tempNumber = 0;
			}
		}
	}

	public static boolean isValidPart(int start, int end, int row, int column){
		ArrayList<Boolean> res = new ArrayList<>();
		if(row < 0 || row > inputs.length || column < 0 || column > inputs[row].length){
			return false;
		}
		if(inputs[row][column] != '.'){
			return true;
		}
		for(int i = start; i <= end; i++){
			res.add(isValidStretch(i, column));
		}
		return(res.contains(true));
	}

	public static boolean isValidStretch(int row, int column){
		ArrayList<Boolean> res = new ArrayList<>();
		if(row < 0 || row > inputs.length || column < 0 || column > inputs[row].length){
			return false;
		}
		if(inputs[row][column] != '.' && !Character.isDigit(inputs[row][column])){
			return true;
		}
		res.add(isValidStretch(row-1, column));
		res.add(isValidStretch(row+1, column));
		res.add(isValidStretch(row, column-1));
		res.add(isValidStretch(row, column+1));						
		res.add(isValidStretch(row-1, column-1));
		res.add(isValidStretch(row+1, column-1));
		res.add(isValidStretch(row-1, column+1));
		res.add(isValidStretch(row+1, column+1));	


		return(res.contains(true));		
	}





}