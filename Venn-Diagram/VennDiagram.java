import java.io.*;
import java.util.*;

public class VennDiagram {
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner ns = new Scanner(new File("venn.c"));
		ArrayList<Integer> theList = new ArrayList<Integer>();
		int numCases = ns.nextInt(); ns.nextLine();
		for (int x = 0; x < numCases; x++) {
			int num = ns.nextInt();
			while (num != 0) {
				theList.add(num);
				num = ns.nextInt();
			}
			num = ns.nextInt();
			while (num != 0) {
				if (!checkSet(num, theList)) {
					theList.add(num);
				}
				num = ns.nextInt();
			}
			printList(theList);
			theList.clear();
		}
	}
	
	public static boolean checkSet(int num, ArrayList<Integer> list) {
		for (int x = 0; x < list.size(); x++) {
			if (num == list.get(x)) {
				list.remove(x);
				return true;
			}
		}
		return false;
	}
	
	public static void printList(ArrayList<Integer> list) {
		System.out.print("{");
		int x = 0;
		if (list.size() != 0) {
			for (; x < list.size()-1; x++) {
				System.out.print(list.get(x) + ",");
			} 
			System.out.print(list.get(x));
		}
		System.out.println("}");
	}
}
