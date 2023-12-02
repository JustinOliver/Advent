import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
class Day2 {

	static HashMap<String, Integer> map;


	public static void main(String[] args){
		BufferedReader reader;
		String fileName = "Day2Input.txt";
		map = new HashMap<String, Integer>();
		map.put("red", 12);
		map.put("green", 13);
		map.put("blue", 14);

		int sum = 0;

		try{
			reader = new BufferedReader(new FileReader(fileName));
			String line = reader.readLine();

			while(line != null){
				String[] arr = line.split(":");
				String[] gameNum = arr[0].split(" ");
				int currentGame = Integer.parseInt(gameNum[1]);
				System.out.println("Current Game is " + currentGame);
				System.out.println(arr[1]);
				boolean isValid = isValidGame(arr[1]);
				System.out.println("IsValid " + isValid);
				if(isValid){
					sum += currentGame;
				}

				line = reader.readLine();
			}
			reader.close();


		} catch (IOException e){
			e.printStackTrace();
		}
		System.out.println("Sum is: " + sum);
	}


	public static boolean isValidGame(String s){
		String[] tempGame = s.split(";");
		for(int i = 0; i < tempGame.length; i++){
			String[] tempRound = tempGame[i].split(",");
			for(int j = 0; j < tempRound.length; j++){
				String[] tempNum = tempRound[j].trim().split(" ");
				int count = Integer.parseInt(tempNum[0]);
				String word = tempNum[1];
				System.out.println("Count word is" + word + " max is" + map.get(word) + " and count is " + count);
				if(count > map.get(word)){
					return false;
				}
			}
		}

		return true;

	}




}

