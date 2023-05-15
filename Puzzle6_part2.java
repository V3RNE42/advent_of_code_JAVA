package p;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 --- Part Two ---
Your device's communication system is correctly detecting packets, but still isn't working. It looks like it also needs to look for messages.

A start-of-message marker is just like a start-of-packet marker, except it consists of 14 distinct characters rather than 4.

Here are the first positions of start-of-message markers for all of the above examples:

mjqjpqmgbljsphdztnvjfqwrcgsmlb: first marker after character 19
bvwbjplbgvbhsrlpgdmjqwftvncz: first marker after character 23
nppdvjthqldpwncqszvftbrmjlhg: first marker after character 23
nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg: first marker after character 29
zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw: first marker after character 26
How many characters need to be processed before the first start-of-message marker is detected?	 */
public class Puzzle6_part2 {
	
	public static int TOTAL_CHARACTERS = 14;
	public static String num[] = new String[TOTAL_CHARACTERS];
	
	private static Boolean anyNulls() {
		Boolean retorno = false;
		for (int i = 0; i < num.length; i++) {
			if (num[i]==null) {
				retorno = true;
				break;
			}
		}
		return retorno;
	}
	
	private static Boolean found() {
		String s = "";
		for (int i = 0; i < num.length; i++) s+=num[i];
		boolean[] char_set = new boolean[256];
	    for(int i = 0; i < s.length(); i++){
	        int val = s.charAt(i);
	        if(char_set[val]){
	        	return false;
	        } else {
	        	char_set[val] = true;
	        }
	    }
	    return true;
	}
	
	public static void main(String[] args) {

		String line;
		String linea[];
		int count = 0;
		
		for (int i = 0; i < num.length; i++) num[i]= null;
		
		try {
			BufferedReader input = new BufferedReader(
				new FileReader(
					new File(".\\input\\puzzle_6.txt")));
			
			while (input.ready()) {
				
				line = input.readLine();
				linea = line.split("");
				
				for (int i = 0; i < linea.length; i++) {
					if (anyNulls()) {
						if (num[i]==null) {
							num[i]=linea[i];					
						}
					} else {
						if (found()) {
							break;
						} else {
							for (int j = 0; j < TOTAL_CHARACTERS; j++) {
								if (j<(TOTAL_CHARACTERS-1)) {
									num[j] = num[j+1];
								} else {
									num[TOTAL_CHARACTERS-1] = linea[i];
								}
							}
						}					
					}
					count++;				
				}	
			}
			
			System.out.println(count);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
