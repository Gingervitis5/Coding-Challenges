// I have attempted the extra credit
//
//
import java.util.*;
import java.io.*;

public class Knapsack {

	public static void main(String[] args) throws FileNotFoundException {
		String inputFileName = "backpack.in";
		if (args.length == 1) {
			inputFileName = args[0];
		}
		Scanner inf = new Scanner(new File (inputFileName));
		int numData = inf.nextInt();
		
// Finding the best benefit
		for (; numData > 0; numData--) {
			int maxWeight = inf.nextInt(), numItems = inf.nextInt(), i = 1, w = 0;
			int[][] valueTable = new int[numItems+1][maxWeight+1];
			int[] weights = new int[numItems+1], benefits = new int[numItems+1];
			for (int y = 1; y < numItems+1; y++) {
				weights[y] = inf.nextInt();
				benefits[y] = inf.nextInt();
			}
			/*for (; w < maxWeight+1; w++) {
				valueTable[0][w] = 0;
			}
			for (; i < numItems+1; i++) {
				valueTable[i][0] = 0;
			}*/
			for (i = 1; i < numItems+1; i++) {
				for (w = 0; w < maxWeight+1; w++) {
					if (weights[i] <= w) {
						if (benefits[i] + valueTable[i-1][w - weights[i]] > valueTable[i-1][w]) {
							valueTable[i][w] = benefits[i] + valueTable[i-1][w - weights[i]];
						}
						else {
							valueTable[i][w] = valueTable[i-1][w];
						}
					}
					else {
						valueTable[i][w] = valueTable[i-1][w];
					}
				}
			}
// Finding the items 
			int item = numItems, k = maxWeight; int z = 0; int[] theItems = new int[numItems];
			while (item > 0 && k > 0) {
				if (valueTable[item][k] != valueTable[item-1][k]) {
					theItems[z] = item; z++;
					item = item-1; k = k-weights[item+1];
				}
				else {
					item = item-1;
				}
			}
			//SelectionSort(theItems);
// Printing out the data
			int weight = 0, benefit = 0; int a = 0;
			String itemNums = ", Items: ";
			for (; a < theItems.length && theItems[a] != 0; a++) {
				weight += weights[theItems[a]];
				benefit += benefits[theItems[a]];
				itemNums += theItems[a] + " ";
			}
			System.out.println("Backpack Weight: " + maxWeight + 
					", Loaded Weight: " + weight + 
					", Benefit: " + benefit + itemNums);
		}
		
		inf.close();
	}
	
	/*public static void SelectionSort(int[] array) {
		int start, search, min;
		int temp;
		for (start = 0; start < array.length-1; start++) {
			min = start;
			for (search = start+1; search < array.length; search++) {
				if (array[search] < array[min]) {
					min = search;
				}
			}
			temp = array[start];
			start = array[min];
			array[min] = temp;
		}
	}*/
}
