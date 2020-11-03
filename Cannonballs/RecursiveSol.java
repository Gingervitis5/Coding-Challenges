/* Graham Mix
 * 
 * Tetrahedron Problem Recursive Solution
 * Edge Cases I tested:
 * If the side ball count is 1
 * If the side ball count is 999
 */

import java.util.*;
import java.io.*;

public class RecursiveSol {

	public static int ballCount(int side) {
		if (side == 1) {
			return 1;
		}
		else {
			return levelCount(side) + ballCount(side-1);
		}
	}
	
	static int levelCount(int side) {
		if (side == 1) {
			return 1;
		}
		else if (side == 0) {
			return 0;
		}
		return side + levelCount(side-1);
	}

	public static void main(String[] args) throws FileNotFoundException{
		String inputFileName = "input.txt";
		if (args.length == 1) {
			inputFileName = args[0];
		}
		
		long startTime = System.currentTimeMillis();
		Scanner inp = new Scanner(new File(inputFileName));
		int numProbs = inp.nextInt(); int x = 0, y = 1;
		for (; x < numProbs; x++, y++) {
			int side = inp.nextInt();
			System.out.println(y + ": " + side + " " + ballCount(side));
		}
		long endTime = System.currentTimeMillis();

		System.out.println("\nTime in seconds: " + String.format("%.5f", (float)(endTime - startTime)));
		inp.close();
		
		
	}
	
	/*
	 *private static int levelCount(int level){
	 *	if (levelValues(level) == 0){
	 *		levelValues(level) = level + levelCount(level - 1);
	 *	}
	 *	return levelValues(level);
	 * }
	 * 
	 *
	 */
	
}
