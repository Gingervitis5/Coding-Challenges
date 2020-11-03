// Graham Mix
// Problem 2.8.3 Hartals
/* Edge Cases I tested for:
 * 7 days
 * 3650 days
 * 1 Political Party
 * 100 Political Parties
*/
package main;
import java.util.*;
import java.io.*;

public class Hartal {
	
	public static void main(String[] args) throws FileNotFoundException {
		String inputFileName = "input.txt";
		if (args.length == 1) {
			inputFileName = args[0];
		}
		Scanner inf = new Scanner(new File (inputFileName));
		
		int testCases = inf.nextInt(); inf.nextLine();
		int numDays, numPartys, daysLost = 0;
		int[] hParameters; char[] schedule;
		for (int x = 0; x < testCases; x++) {
			numDays = inf.nextInt(); inf.nextLine();
			numPartys = inf.nextInt(); inf.nextLine();
			hParameters = new int[numPartys]; 
			schedule = new char[numDays]; 
			for (int ix = 5; ix < schedule.length; ix = ix+7) {
				schedule[ix] = 'X';
				schedule[ix+1] = 'X';
			}
			for (int ix = 0; ix < numPartys; ix++) {
				hParameters[ix] = inf.nextInt();
			}
			for (int d = 1; d <= numDays; d++) {
				for (int ix = 0; ix < numPartys; ix++) {
					if (d % hParameters[ix] == 0 && (schedule[d-1] != 'X' && schedule[d-1] != 'H')) {
						schedule[d-1] = 'H';
					}
				}
			}
			for (int d = 0; d < schedule.length; d++) {
				if (schedule[d] == 'H') {
					daysLost++;
				}
			}
			System.out.println(daysLost);
			daysLost = 0;
		}
	}
}
