/*Graham Mix
 * This program checks first off to see if the upper left coordinate of one 
 * rectangle lies either above, to the side, or diagonal of the other rectangle.
 * If not, then there is no overlap. If it is, then it checks to see where the overlap
 * is (above, parallel to, or diagonal) and returns a new rectangle that is the overlap.
 * 
 * The Edge Cases I tested for are:
 * No Overlap
 * Share a common point
 * Share a common edge
 * Rectangles are the same
 * Fully Contained
*/

import java.util.*;

public class OverlappingRectangles {

	public static void main(String[] args) {
		
		Scanner inp = new Scanner(System.in);
		int upperY1, upperX1, lowerY1, lowerX1;
		int upperY2, upperX2, lowerY2, lowerX2;
		boolean done = false; String choice;
		while (!done) {
			System.out.print("Enter upper left X coordinate of first rectangle: "); upperX1 = inp.nextInt(); 
			System.out.print("Enter upper left Y coordinate of first rectangle: "); upperY1 = inp.nextInt();
			System.out.print("Enter lower right X coordinate of first rectangle: "); lowerX1 = inp.nextInt();
			System.out.print("Enter lower right Y coordinate of first rectangle: "); lowerY1 = inp.nextInt();
			System.out.println();
			System.out.print("Now enter upper left X coordinate of second rectangle: "); upperX2 = inp.nextInt();
			System.out.print("And the upper left Y coordinate of the second rectangle: "); upperY2 = inp.nextInt();
			System.out.print("Next, enter the lower right X coordinate of the second rectangle: "); lowerX2 = inp.nextInt();
			System.out.print("And finally, the lower right Y coordinate of the second rectangle: "); lowerY2 = inp.nextInt();
			
			Rectangle rec1 = new Rectangle(upperX1, upperY1, lowerX1, lowerY1);
			Rectangle rec2 = new Rectangle(upperX2, upperY2, lowerX2, lowerY2);
			Rectangle overlap = Rectangle.compareRecs(rec1, rec2);
			
			System.out.print("The rectangles with corner coordinates ("+ upperX1 + ", " + upperY1 + ") ("
																		+ lowerX1 + ", " + lowerY1 + ") and ("
																		+ upperX2 + ", " + upperY2 + ") ("
																		+ lowerX2 + ", " + lowerY2 + ") overlap at: ");
			if (overlap.x1 == -1){
				System.out.println("No overlap found");
			}
			else {
				System.out.println("(" + overlap.x1 + ", " + overlap.y1 + ") (" + overlap.x2 + ", " + overlap.y2 + ")");
			}
			System.out.print("\nEnter 'y' to try another set of rectangles, any other character to quit: ");
			inp.nextLine();
			choice = inp.nextLine();
			switch(choice) {
			case "y":
				System.out.println();
				break;
			default:
				done = true; inp.close();
			}	
		}
	}
}

class Rectangle {
	public int x1;
	public int y1;
	public int x2;
	public int y2;
	
	public Rectangle(int upperX, int upperY, int lowerX, int lowerY) {
		this.x1 = upperX;
		this.y1 = upperY;
		this.x2 = lowerX;
		this.y2 = lowerY;
	}
	
	public static Rectangle compareRecs(Rectangle r1, Rectangle r2) {
		Rectangle overlap = new Rectangle(-1,-1,-1,-1);
		if (isContained(r1, r2)) { //Check if r1 is/contained in r2
			return r1;
		}
		else if (isContained(r2, r1)) { //Check if r2 is/contained in r1
			return r2;
		}
		else if (isOverlapping(r1, r2)) {
			if (isAbove(r1, r2)) {
				if (r1.y2 <= r2.y2 && r1.y2 > r2.y1) {
					overlap.x1 = r1.x1; overlap.y1 = r2.y1;
					overlap.x2 = r2.x2; overlap.y2 = r1.y2;
				}
				else if (r1.y2 > r2.y2 && r1.x2 > r2.x2) {
					overlap.x1 = r1.x1; overlap.y1 = r2.y1;
					overlap.x2 = r2.x2; overlap.y2 = r2.y2;
				}
				else if (r1.y2 < r2.y2 && r1.x2 > r2.x2) {
					overlap.x1 = r1.x1; overlap.y1 = r2.y1;
					overlap.x2 = r2.x2; overlap.y2 = r1.y2;
				}
			}
			else if (isAside(r1, r2)) {
				if (r1.x2 <= r2.x2 && r1.y2 < r2.y2) {
					overlap.x1 = r2.x1; overlap.y1 = r1.y1;
					overlap.x2 = r1.x2; overlap.y2 = r1.y2;
				}
				else if (r1.x2 > r2.x2 && r1.y2 > r2.y2) {
					overlap.x1 = r2.x1; overlap.y1 = r1.y1;
					overlap.x2 = r2.x2; overlap.y2 = r2.y2;
				}
				else if (r1.x2 < r2.x2 && r1.y2 > r2.y2) {
					overlap.x1 = r2.x1; overlap.y1 = r1.y1;
					overlap.x2 = r1.x2; overlap.y2 = r2.y2;
				}
			}
			else if (isDiagonal(r1, r2)) {
				if ( (r1.x2 > r2.x1 && r1.y2 > r2.y1) && (r1.x2 < r2.x2 && r1.y2 < r2.y2) ) {
					overlap.x1 = r2.x1; overlap.y1 = r2.y1;
					overlap.x2 = r1.x2; overlap.y2 = r1.y2;
				}
			}
		}
		return overlap;
	}
	
	static boolean isContained(Rectangle rect1, Rectangle rect2) {
		if ( rect1.x1 == rect2.x1 && rect1.y1 == rect2.y1 && rect1.x2 == rect2.x2 && rect1.y2 == rect2.y2 ) {
			return true;
		}
		else if ( ((rect1.x1 > rect2.x1 && rect1.x2 < rect2.x2) && (rect1.y1 > rect2.y1 && rect1.y2 < rect2.y2)) ) {
			return true;
		}
		return false;
	}
	
	static boolean isOverlapping(Rectangle rect1, Rectangle rect2) {
		if (isAbove(rect1, rect2)) { //If rect1 is above rect2
			if ( rect1.y2 < rect2.y1 ) { //If the lower y value is outside the upper coordinate of rect2
				return false;
			}
			return true;
		}
		else if (isAside(rect1, rect2)) { //If rect1 is parallel to rect2
			if ( rect1.x2 < rect2.x1) { //If the lower x value of rect1 is less than the upper x of rect2
				return false;
			}
			return true;
		}
		else if (isDiagonal(rect1, rect2)) {
			if (rect1.x2 < rect2.x1 || rect1.y2 < rect2.y1) { //If the rectangle doesn't go enough right and down, return false
				return false;
			}
			return true;
		}
		return false;
	}
	
	//See's if the upper coordinate of rect1 is between the upper and lowers x value of rect2 
	static boolean isAbove(Rectangle rect1, Rectangle rect2) {
		if (rect1.y1 <= rect2.y1 && rect1.x1 >= rect2.x1 && rect1.x1 < rect2.x2) {
			return true;
		}
		return false;
	}
	
	//See's if the upper coordinate of rect1 lies between the upper and lowers y values of rect2
	static boolean isAside(Rectangle rect1, Rectangle rect2) {
		if (rect1.x1 <= rect2.x1 && rect1.y1 >= rect2.y1 && rect1.y1 < rect2.y2) {
			return true;
		}
		return false;
	}
	
	//See's if upper coordinate of rect1 lays above and to the left of rect2
	static boolean isDiagonal(Rectangle rect1, Rectangle rect2) {
		if (rect1.x1 < rect2.x1 && rect1.y1 < rect2.y1) {
			return true;
		}
		return false; 
	}
}











