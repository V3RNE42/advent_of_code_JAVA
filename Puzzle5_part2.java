package p;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**  As you watch the crane operator expertly rearrange the crates, you notice the process isn't following your prediction.

Some mud was covering the writing on the side of the crane, and you quickly wipe it away. The crane isn't a CrateMover 9000 - it's a CrateMover 9001.

The CrateMover 9001 is notable for many new and exciting features: air conditioning, leather seats, an extra cup holder, and the ability to pick up and move multiple crates at once.

Again considering the example above, the crates begin in the same configuration:

    [D]    
[N] [C]    
[Z] [M] [P]
 1   2   3 
Moving a single crate from stack 2 to stack 1 behaves the same as before:

[D]        
[N] [C]    
[Z] [M] [P]
 1   2   3 
However, the action of moving three crates from stack 1 to stack 3 means that those three moved crates stay in the same order, resulting in this new configuration:

        [D]
        [N]
    [C] [Z]
    [M] [P]
 1   2   3
Next, as both crates are moved from stack 2 to stack 1, they retain their order as well:

        [D]
        [N]
[C]     [Z]
[M]     [P]
 1   2   3
Finally, a single crate is still moved from stack 1 to stack 2, but now it's crate C that gets moved:

        [D]
        [N]
        [Z]
[M] [C] [P]
 1   2   3
In this example, the CrateMover 9001 has put the crates in a totally different order: MCD.

Before the rearrangement process finishes, update your simulation so that the Elves know where they should stand to be ready to unload the final supplies. After the rearrangement procedure completes, what crate ends up on top of each stack?  */
public class Puzzle5_part2 {

	private static ArrayList<ArrayList<String>> column = new ArrayList<ArrayList<String>>();
	private static int TOTAL_COLUMNS = 9;
	private static int TOTAL_ROWS	 = 8;

	public static void main(String[] args) {

		String line = null;
		String linea[] = new String[35];
		String crate = "";
		
		try {
			BufferedReader input = new BufferedReader(
				new FileReader(
					new File("C:\\Users\\usuario\\eclipse-workspace\\Advent_of_Code\\input\\puzzle_5.txt")));
			
			for (int i = 0; i < TOTAL_COLUMNS; i++) column.add(i, new ArrayList<String>());
			
			for (int i = 0; i < TOTAL_ROWS; i++) {
				line = input.readLine();
				linea = line.split("");
				for (int j = 1, k=0; j < linea.length && k<=TOTAL_COLUMNS; j+=4, k++) {
					if (!linea[j].equalsIgnoreCase(" ")) {
						column.get(k).add(linea[j]);
					}
				}
			}
			 
			for (int i = 0; i < TOTAL_COLUMNS; i++) Collections.reverse(column.get(i));
			
			for (int i = 0; i < 2; i++) input.readLine();
			
			while (input.ready()) {
				line = input.readLine();
				linea = line.split(" ");

				int amount  = Integer.parseInt(linea[1], 10);
				int origin  = Integer.parseInt(linea[3], 10)-1;
				int destiny = Integer.parseInt(linea[5], 10)-1;
				
				for (int i = 0; i < amount; i++) {					
					crate = column.get(origin).get(column.get(origin).size()-(amount-i));
					column.get(origin).set(column.get(origin).size()-(amount-i), null);
					column.get(origin).removeIf(n -> (n==null));
					column.get(destiny).add(crate);					
				} 
								 
				line = "";
			}
			for (int i = 0; i < column.size(); i++) {
				System.out.print(column.get(i).get(column.get(i).size()-1));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
