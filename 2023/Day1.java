import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

class Day1 {

	public static Map<String, String> wordNums;

	public static void main(String args[]){
		BufferedReader reader;
		String fileName = "Day1Input.txt";
		int calibrationSum = 0;
		wordNums = new HashMap<String, String>();

		fillWordNums();

		try{
			reader = new BufferedReader(new FileReader(fileName));
			String line = reader.readLine();

			while(line != null){
				String newLine = replaceWords(line);
				calibrationSum += getLineValue(newLine);
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e){
			e.printStackTrace();
		}
		System.out.println(calibrationSum);
	}

	public static int getLineValue(String line){
		List<Integer> res = new ArrayList<>();
		for(int i = 0; i < line.length(); i++){
			char currentChar = line.charAt(i);
			if(Character.isDigit(currentChar)){
				res.add(Character.getNumericValue(currentChar));
			}
		}
		return getDoubleDigit(res);
	}

	public static int getDoubleDigit(List<Integer> num){
		if(num.size() == 1){
			return (num.get(0) * 10 + num.get(0));
		} else if(num.size() == 2){
			return (num.get(0) * 10 + num.get(1));
		} else {
			return (num.get(0) * 10 + num.get(num.size()-1));
		}
	}

	public static void fillWordNums(){
		wordNums.put("one", "o1e");
		wordNums.put("two", "t2o");
		wordNums.put("three", "t3e");
		wordNums.put("four", "f4r");
		wordNums.put("five", "f5e");
		wordNums.put("six", "s6x");
		wordNums.put("seven", "s7n");
		wordNums.put("eight", "e8t");
		wordNums.put("nine", "n9e");
	}

	public static String replaceWords(String line){
		String res = line;
		for(Map.Entry<String, String> entry : wordNums.entrySet()){
			String key = entry.getKey();
			String value = entry.getValue();
			res = res.replace(key, value);
		}
		return res;
	}
}