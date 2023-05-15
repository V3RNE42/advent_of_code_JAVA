package p;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Puzzle1_part2 {

	public static void main(String[] args) {

		int num = 0;
		Integer cal[] = new Integer[2000];
		for (int i = 0; i < cal.length; i++) {
			cal[i]=0;
		}
		String linea = null;
		
		try {
			BufferedReader input = new BufferedReader(
				new FileReader(
					new File("C:\\Users\\usuario\\eclipse-workspace\\Advent_of_Code\\input\\puzzle_1.txt")));
			while (input.ready()) {
				linea = input.readLine();
				if (linea.length()>1) {
					cal[num]+=Integer.valueOf(linea, 10);
				} else {
					num++;
				}
			}
			int change = 0;
			for (int i = 0; i < num; i++) {
				for (int j = 0; j < num; j++) {
					if (cal[i] > cal[j]) {
						change = cal[i];
						cal[i] = cal[j];
						cal[j] = change;
					}
				}
			}
			
			System.out.println(cal[0]+cal[1]+cal[2]);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
