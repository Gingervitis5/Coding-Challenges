public class OddNumber {

	public static int findNumbers(int[] array) {
		int x, y, count = 0, theNum;
		while (count == 0) {
			for (x = 0; x < array.length; x++) {
				theNum = array[x];
				for (y = 0; y < array.length; y++) {
					if(theNum == array[y]) {
						count++;
					}
				}
				if (count % 2 == 0) {
					count = 0;
				}
				else if (count % 2 != 0){
					return theNum;
				}
			}
		}
		return 0;
	}
	
	public static void main(String[] args) {
		int[] theNums = {1,3,3,5,5,5,5,7,7,7,7,7,7};
		int[] theInts = {7,6,10,9,4,6,10,3,5,6,8,6,4,7,3,5,8,8,8};
		int[] noNums = {1,1,2,2,3,3};
		System.out.println(findNumbers(theNums));
		System.out.println(findNumbers(theInts));
		System.out.println(findNumbers(noNums));
	}

}
