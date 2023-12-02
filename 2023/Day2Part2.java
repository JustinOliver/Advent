import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
class Day2Part2 {

	static HashMap<String, Integer> map;


	public static void main(String[] args){
		BufferedReader reader;
		String fileName = "Day2Input.txt";
		map = new HashMap<String, Integer>();
		int power = 0;

		try{
			reader = new BufferedReader(new FileReader(fileName));
			String line = reader.readLine();

			while(line != null){
				String[] arr = line.split(":");
				int gamePower = getGameSum(arr[1]);
				power += gamePower;
				line = reader.readLine();
			}
			reader.close();


		} catch (IOException e){
			e.printStackTrace();
		}
		System.out.println("Sum is: " + power);
	}

	public static int getGameSum(String s){
		map.clear();
		map.put("red", 0);
		map.put("green", 0);
		map.put("blue", 0);
		int power = 0;
		String[] tempGame = s.split(";");
		for(int i = 0; i < tempGame.length; i++){
			String[] tempRound = tempGame[i].split(",");
			for(int j = 0; j < tempRound.length; j++){
				String[] tempNum = tempRound[j].trim().split(" ");
				int count = Integer.parseInt(tempNum[0]);
				String word = tempNum[1];
				map.put(word, Math.max(map.get(word), count));
			}
		}
		power = map.get("blue") * map.get("red") * map.get("green");
		return power;
	}
}

