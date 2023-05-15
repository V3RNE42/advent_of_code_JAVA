package p;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**  --- Day 5: Supply Stacks ---
The expedition can depart as soon as the final supplies have been unloaded from the ships. Supplies are stored in stacks of marked crates, but because the needed supplies are buried under many other crates, the crates need to be rearranged.

The ship has a giant cargo crane capable of moving crates between stacks. To ensure none of the crates get crushed or fall over, the crane operator will rearrange them in a series of carefully-planned steps. After the crates are rearranged, the desired crates will be at the top of each stack.

The Elves don't want to interrupt the crane operator during this delicate procedure, but they forgot to ask her which crate will end up where, and they want to be ready to unload them as soon as possible so they can embark.

They do, however, have a drawing of the starting stacks of crates and the rearrangement procedure (your puzzle input). For example:

    [D]    
[N] [C]    
[Z] [M] [P]
 1   2   3 

move 1 from 2 to 1
move 3 from 1 to 3
move 2 from 2 to 1
move 1 from 1 to 2
In this example, there are three stacks of crates. Stack 1 contains two crates: crate Z is on the bottom, and crate N is on top. Stack 2 contains three crates; from bottom to top, they are crates M, C, and D. Finally, stack 3 contains a single crate, P.

Then, the rearrangement procedure is given. In each step of the procedure, a quantity of crates is moved from one stack to a different stack. In the first step of the above rearrangement procedure, one crate is moved from stack 2 to stack 1, resulting in this configuration:

[D]        
[N] [C]    
[Z] [M] [P]
 1   2   3 
In the second step, three crates are moved from stack 1 to stack 3. Crates are moved one at a time, so the first crate to be moved (D) ends up below the second and third crates:

        [Z]
        [N]
    [C] [D]
    [M] [P]
 1   2   3
Then, both crates are moved from stack 2 to stack 1. Again, because crates are moved one at a time, crate C ends up below crate M:

        [Z]
        [N]
[M]     [D]
[C]     [P]
 1   2   3
Finally, one crate is moved from stack 1 to stack 2:

        [Z]
        [N]
        [D]
[C] [M] [P]
 1   2   3
The Elves just need to know which crate will end up on top of each stack; in this example, the top crates are C in stack 1, M in stack 2, and Z in stack 3, so you should combine these together and give the Elves the message CMZ.

After the rearrangement procedure completes, what crate ends up on top of each stack?  */
public class Puzzle5 {

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
					crate = column.get(origin).get(column.get(origin).size()-1);
					column.get(origin).set(column.get(origin).size()-1, null);
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
