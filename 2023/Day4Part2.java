import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

class Day4Part2 {
	
	static Character[][] inputs;
	static ArrayList<ArrayList<Character>> input;
	static int rows = 0;
	static int sum = 0;

	public static void main(String[] args){
		BufferedReader reader;
		String fileName = "Day4Input.txt";
		long totalScore = 0;
		HashMap<Integer, Integer> cardCount = new HashMap<>();
		int currentCard = 0;
		int tempCount = 0;
		int cur;

		try {
			reader = new BufferedReader(new FileReader(fileName));
			String line = reader.readLine();
			System.out.println("hi");

			while(line != null){
				cardCount.put(currentCard, cardCount.getOrDefault(currentCard, 1));
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
							tempCount++;
						}
					}					
				}
				cur = currentCard+1;
				for(int i = 0; i < tempCount; i++){	
					cardCount.put(cur+i, cardCount.getOrDefault(cur+i, 1) + cardCount.get(currentCard));
				}

				line = reader.readLine();
				tempCount = 0;
				currentCard++;
			}
			reader.close();
		} catch (IOException e){
			e.printStackTrace();
		}
		for(Map.Entry<Integer,Integer> mapElement : cardCount.entrySet()){
			totalScore += mapElement.getValue();
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