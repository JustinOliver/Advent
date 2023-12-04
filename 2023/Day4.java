import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

class Day4 {
	
	static Character[][] inputs;
	static ArrayList<ArrayList<Character>> input;
	static int rows = 0;
	static int sum = 0;

	public static void main(String[] args){
		BufferedReader reader;
		String fileName = "Day4Input.txt";
		int totalScore = 0;
		int tempScore = 0;
		boolean first = true;


		try {
			reader = new BufferedReader(new FileReader(fileName));
			String line = reader.readLine();
			System.out.println("hi");
			while(line != null){
				String[] cardInfo = line.split(":");
				String[] numbers = cardInfo[1].split("\\|");
				String[] winningNumbers = numbers[0].split(" ");
				String[] myNumbers = numbers[1].split(" ");
				HashSet<String> wn = new HashSet<>();
				for(int i = 0; i < winningNumbers.length; i++){
					if(isNumeric(winningNumbers[i])){
						wn.add(winningNumbers[i]);
					}
				}
				for(int i = 0; i < myNumbers.length; i++){
					if(isNumeric(myNumbers[i])){
						if(wn.contains(myNumbers[i])){
							if(first){
								tempScore = 1;
								first = false;
							} else {
								tempScore = tempScore *2;
							}
						}
					}					
				}
				totalScore += tempScore;
				line = reader.readLine();
				tempScore = 0;
				first = true;
			}
			reader.close();
		} catch (IOException e){
			e.printStackTrace();
		}
		System.out.println(totalScore);	
	}

	public static boolean isNumeric(String strNum) {
	    if (strNum == null) {
	        return false;
	    }
	    try {
	        int d = Integer.parseInt(strNum);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}



}