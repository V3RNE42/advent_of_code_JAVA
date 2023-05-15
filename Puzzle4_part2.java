package p;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/** --- Part Two ---
It seems like there is still quite a bit of duplicate work planned. Instead, the Elves would like to know the number of pairs that overlap at all.

In the above example, the first two pairs (2-4,6-8 and 2-3,4-5) don't overlap, while the remaining four pairs (5-7,7-9, 2-8,3-7, 6-6,4-6, and 2-6,4-8) do overlap:

5-7,7-9 overlaps in a single section, 7.
2-8,3-7 overlaps all of the sections 3 through 7.
6-6,4-6 overlaps in a single section, 6.
2-6,4-8 overlaps in sections 4, 5, and 6.
So, in this example, the number of overlapping assignment pairs is 4.

In how many assignment pairs do the ranges overlap?  */
public class Puzzle4_part2 {

	public static void main(String[] args) {

		String line = null;
		int range[]  = new int[4];
		int count = 0;

		try {
			BufferedReader input = new BufferedReader(new FileReader(new File(".\\input\\puzzle_4.txt")));
			
			while (input.ready()) {
				int exc = 0;
				line = input.readLine();

				for (int i = 0; i < 4; i++) {
					range[i] = Integer.parseInt(line.split(",")[i<2?0:1].split("-")[i%2==0?1:0], 10);						
				}
				
				for (int i = 0; i < 2; i++) {					
					if (range[i==0?0:2] > range[i==0?1:3]) {
									exc = range[i==0?0:2];
						range[i==0?0:2] = range[i==0?1:3];
						range[i==0?1:3] = exc;
					}
				}
				
				if ((range[0]+range[1]) > (range[2]+range[3])) {
					for (int i = 0; i < 2; i++) {			
									exc = range[i==0?0:1];
						range[i==0?0:1] = range[i==0?2:3];
						range[i==0?2:3] = exc;
					}
				}
				
				if ((range[0]<=range[2] && range[3]<=range[1])
				 || (range[0]>=range[2] && range[3]>=range[1])
				 || (range[1]>=range[2])) count++;

			}
			System.out.println(count);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
