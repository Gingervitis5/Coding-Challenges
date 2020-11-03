/* Graham Mix

 * Problem 2.8.1 Jolly Jumpers
 * Edge Cases I tested:
 * Only 1 number
 * Negative Numbers included
 * The absolute values of successive numbers are not in order
 * Ascending/Descending elements
 * Single Digits
 * Double Digits
 * Triple Digits
 * Quadruple Digits
*/
import java.io.*;
import java.util.*;

public class JollyJumpers {

	public static int[] getNums(final Scanner inp) throws FileNotFoundException {
		int length = inp.nextInt(); int x = 0; 
		int[] temp = new int[length];
		for (; x < length; x++) {
			temp[x] = inp.nextInt();
		}
		return temp;
		
	}
	
	public static boolean isJollyJumper(final int[] array) {
		boolean isJolly = true;
		int[] jolly = new int[array.length-1]; 
		int x = 0; int y = 0;
		for (; x < jolly.length; x++) {
			jolly[x] = x+1;
		}
		x = 0;
		if (array.length == 1) {
			isJolly = true;
		}
		else if (array.length < 1) {
			isJolly = false;
		}
		else {
			for (; x < array.length-1; x++) {
				for (; y < jolly.length; y++) {
					if ( Math.abs(array[x] - array[x+1]) == jolly[y] ) {
						jolly[y] = 0;
					}
				}
				y = 0;
			}
			x = 0;
			for (; x < jolly.length; x++) {
				if (jolly[x] != 0) {
					isJolly = false;
				}
			}
		}
		
		return isJolly;
		
	}
	
	public static void main(String[] args) throws FileNotFoundException { 
		String inputFileName = "input.txt";
		if (args.length == 1) {
			inputFileName = args[0];
		}
		
		Scanner inp = new Scanner(new File(inputFileName));
		while (inp.hasNext()) {
			int[] theNums = getNums(inp);
			if (isJollyJumper(theNums)) {
				System.out.println("Jolly");
			}
			else {
				System.out.println("Not jolly");
			}
		}
		inp.close();
	}
	
}
