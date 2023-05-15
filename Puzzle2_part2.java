package p;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*  --- Part Two ---
The Elf finishes helping with the tent and sneaks back over to you. "Anyway, the second column says how the round needs to end: X means you need to lose, Y means you need to end the round in a draw, and Z means you need to win. Good luck!"

The total score is still calculated in the same way, but now you need to figure out what shape to choose so the round ends as indicated. The example above now goes like this:

In the first round, your opponent will choose Rock (A), and you need the round to end in a draw (Y), so you also choose Rock. This gives you a score of 1 + 3 = 4.
In the second round, your opponent will choose Paper (B), and you choose Rock so you lose (X) with a score of 1 + 0 = 1.
In the third round, you will defeat your opponent's Scissors with Rock for a score of 1 + 6 = 7.
Now that you're correctly decrypting the ultra top secret strategy guide, you would get a total score of 12.

Following the Elf's instructions for the second column, what would your total score be if everything goes exactly according to your strategy guide?  */
public class Puzzle2_part2 {

	public static void main(String[] args) {

		String linea[] = {null, null};
		String line = null;
		int myScore  = 0;
		try {
			BufferedReader input = new BufferedReader(
					new FileReader(
						new File("C:\\Users\\usuario\\eclipse-workspace\\Advent_of_Code\\input\\puzzle_2.txt")));
			while (input.ready()) {
				line = input.readLine();
				linea = line.split(" ");
				
				if (linea[1].equalsIgnoreCase("Y")) {
					myScore+=3;
					switch (linea[0]) {
						case "A":	myScore++;		break;
						case "B":	myScore+=2;		break;
						case "C":	myScore+=3;		break;}
				} else if (linea[1].equalsIgnoreCase("Z")) {
					myScore+=6;
					switch (linea[0]) {
						case "A":	myScore+=2;		break;
						case "B":	myScore+=3;		break;
						case "C":	myScore++;		break;}
				} else {
					switch (linea[0]) {
						case "A":	myScore+=3;		break;
						case "B":	myScore++;		break;
						case "C":	myScore+=2;		break;}					
				}
			}
			System.out.println("my Score: "+myScore);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
