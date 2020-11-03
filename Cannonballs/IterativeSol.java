/* Graham Mix
 * 
 * Tetrahedron Problem Iterative Solution
 * Edge Cases I tested:
 * If the side ball count is 1
 * If the side ball count is 999
 */

import java.io.*;
import java.util.*;

public class IterativeSol {

	public static int ballCount(int startSide) {
		if (startSide == 1 || startSide == 0) {
			return startSide;
		}
		int count = 0, x = startSide, y = 0;
		for (; x > 0; x--, y = 0) {
			for (; y <= x; y++) {
				count += y;
			}
		}
		return count;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		String inputFileName = "input.txt";
		if (args.length == 1) {
			inputFileName = args[0];
		}
		
		long startTime = System.currentTimeMillis()%1000;
		Scanner inp = new Scanner(new File(inputFileName));
		int numProbs = inp.nextInt(); int x = 0, y = 1;
		for (; x < numProbs; x++, y++) {
			int side = inp.nextInt();
			System.out.println(y + ": " + side + " " + ballCount(side));
		}
		
		long endTime = System.currentTimeMillis()%1000;

		System.out.println("\nTime in seconds: " + String.format("%.5f", (float)(endTime - startTime)));	
		inp.close();
	}
	
}
