package p;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/** --- Part Two ---
As you finish identifying the misplaced items, the Elves come to you with another issue.

For safety, the Elves are divided into groups of three. Every Elf carries a badge that identifies their group. For efficiency, within each group of three Elves, the badge is the only item type carried by all three Elves. That is, if a group's badge is item type B, then all three Elves will have item type B somewhere in their rucksack, and at most two of the Elves will be carrying any other item type.

The problem is that someone forgot to put this year's updated authenticity sticker on the badges. All of the badges need to be pulled out of the rucksacks so the new authenticity stickers can be attached.

Additionally, nobody wrote down which item type corresponds to each group's badges. The only way to tell which item type is the right one is by finding the one item type that is common between all three Elves in each group.

Every set of three lines in your list corresponds to a single group, but each group can have a different badge item type. So, in the above example, the first group's rucksacks are the first three lines:

vJrwpWtwJgWrhcsFMMfFFhFp
jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL
PmmdzqPrVvPwwTWBwg
And the second group's rucksacks are the next three lines:

wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn
ttgJtRGJQctTZtZT
CrZsJsPPZsGzwwsLwLmpwMDw
In the first group, the only item type that appears in all three rucksacks is lowercase r; this must be their badges. In the second group, their badge item type must be Z.

Priorities for these items must still be found to organize the sticker attachment efforts: here, they are 18 (r) for the first group and 52 (Z) for the second group. The sum of these is 70.

Find the item type that corresponds to the badges of each three-Elf group. What is the sum of the priorities of those item types?*/
public class Puzzle3_part2 {

	public static void main(String[] args) {

		char[] items1 = new char[100];
		String line1 = null;
		char[] items2 = new char[100];
		String line2 = null;
		char[] items3 = new char[100];
		String line3 = null;
		int priority = 0;

		try {
			BufferedReader input = new BufferedReader(
				new FileReader(
					new File("C:\\Users\\usuario\\eclipse-workspace\\Advent_of_Code\\input\\puzzle_3.txt")));
			
			while (input.ready()) {
				line1 = input.readLine();
				line2 = input.readLine();
				line3 = input.readLine();
				for (int x = 0; x < line1.length(); x++) items1[x] = line1.charAt(x);			
				for (int x = 0; x < line2.length(); x++) items2[x] = line2.charAt(x);			
				for (int x = 0; x < line3.length(); x++) items3[x] = line3.charAt(x);			
								
				for (int i = 0; i < line1.length(); i++) {
					for (int j = 0; j < line2.length(); j++) {
						for (int k = 0; k < line3.length(); k++) {
							if (items1[i]==items2[j] && items1[i]==items3[k]) {
								if (items1[i]<97) {
									priority+=((int) items1[i]-38);
								} else {
									priority+=((int) items1[i]-96);
								}
								line1 = "";
								line2 = "";
								line3 = "";
								break;								
							}
						}
					}
				}				
			}
			System.out.println(priority);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
