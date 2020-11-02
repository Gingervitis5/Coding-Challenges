// Graham Mix
// Problem 1.6.5 Graphical Editor
/* Edge Cases I tested for:
 * A 1x1 Picture
 * A 250x250 Picture
 * An illegal command
 * Functionality of all the commands
 * Drawing an actual picture
 */

import java.io.*;
import java.util.*;

public class Graphical_Editor {

	public static void main(String[] args) throws FileNotFoundException {
		String inputFileName = "input.txt";
		if (args.length == 1) {
			inputFileName = args[0];
		}
		Scanner inf = new Scanner(new File (inputFileName));
		String command = inf.nextLine();
		String[] commandLine = command.split(" ");
		char[][] Image = new char[0][0]; int row, col, x, y, z;
		while (command.charAt(0) != 'X') {
			switch(command.charAt(0)) {
			case 'I':
				col = Integer.parseInt(commandLine[1]);
				row = Integer.parseInt(commandLine[2]);
				Image = setImage(row, col);
				command = setCommand(command, inf);
				commandLine = command.split(" ");
				break;
			case 'C':
				clearImage(Image);
				command = setCommand(command, inf);
				commandLine = command.split(" ");
				break;
			case 'L':
				x = Integer.parseInt(commandLine[1])-1;
				y = Integer.parseInt(commandLine[2])-1;
				String color = commandLine[3];
				if (x >= 0 && y >= 0 && x < Image.length && y < Image[0].length) {
					Image[x][y] = color.charAt(0);
				}
				command = setCommand(command, inf);
				commandLine = command.split(" ");
				break;
			case 'V':
				col = Integer.parseInt(commandLine[1])-1;
				int y1 = Integer.parseInt(commandLine[2])-1; 
				int y2 = Integer.parseInt(commandLine[3])-1;
				color = commandLine[4];
				if (col < Image[0].length && (y1 >= 0 && y2 >= 0 && y1 < Image.length && y2 < Image.length) ) {
					for (z = y1; z <= y2; z++) {
						Image[z][col] = color.charAt(0);
					}
				}
				command = setCommand(command, inf);
				commandLine = command.split(" ");
				break;
			case 'H':
				row = Integer.parseInt(commandLine[3])-1;
				int x1 = Integer.parseInt(commandLine[1])-1; 
				int x2 = Integer.parseInt(commandLine[2])-1;
				color = commandLine[4];
				if (row < Image.length && (x1 >= 0 && x2 >= 0 && x1 < Image[0].length && x2 < Image[0].length) )
					for (z = x1; z <= x2; z++) {
						Image[row][z] = color.charAt(0);
					}
				
				command = setCommand(command, inf);
				commandLine = command.split(" ");
				break;
			case 'K':
				x1 = Integer.parseInt(commandLine[1])-1;
				y1 = Integer.parseInt(commandLine[2])-1;
				x2 = Integer.parseInt(commandLine[3])-1;
				y2 = Integer.parseInt(commandLine[4])-1;
				color = commandLine[5];
				if ((x1 >= 0 && x1 < Image.length) && (x2 >= 0 && x2 < Image.length) && (y1 >= 0 && y1 < Image[0].length) && (y2 >= 0 && y2 < Image[0].length)) {
					for (x = x1; x <= x2; x++) {
						for (y = y1; y <= y2; y++) {
							Image[x][y] = color.charAt(0);
						}
						y = y1;
					}
				}
				command = setCommand(command, inf);
				commandLine = command.split(" ");
				break;
			case 'F':
				x = Integer.parseInt(commandLine[1])-1;
				y = Integer.parseInt(commandLine[2])-1;
				color = commandLine[3];
				char oldColor = Image[x][y];
				if (x >= 0 && y >= 0 && x < Image.length && y < Image[0].length) {
					fillRegion(Image, x, y, oldColor, color);
				}
				command = setCommand(command, inf);
				commandLine = command.split(" ");
				break;
			case 'S':
				String fName = commandLine[1];
				System.out.println(fName);
				printImage(Image);
				command = setCommand(command, inf);
				commandLine = command.split(" ");
				break;
			default:
				command = setCommand(command, inf);
				commandLine = command.split(" ");
			}
		}
		inf.close();
	}
	
	public static char[][] setImage(int x, int y){
		char[][] newImage = new char[x][y];
		for (int r = 0; r < x; r++) {
			for (int c = 0; c < y; c++) {
				newImage[r][c] = 'O';
			}
		}
		return newImage;
	}
	
	public static void clearImage(char[][] Image) {
		for(int x = 0; x < Image.length; x++) {
			for (int y = 0; y < Image[0].length; y++) {
				Image[x][y] = 'O';
			}
		}
	}
	
	public static String setCommand(String com, Scanner inf) {
		com = inf.nextLine();
		return com;
	}
	
	public static void printImage(char[][] Image) {
		for(int x = 0; x < Image.length; x++) {
			for (int y = 0; y < Image[0].length; y++) {
				System.out.print(Image[x][y]);
			}
			System.out.println();
		}
	}
	
	public static boolean fillRegion(char[][] Image, int x, int y, char oldColor, String newColor) {
		if (x < 0 || y < 0 || x >= Image.length || y >= Image[0].length) {
			return false;
		}
		else if (Image[x][y] != oldColor)
		{		
			return false;
		}
		
		Image[x][y] = newColor.charAt(0);
		
		if (fillRegion(Image, x+1, y, oldColor, newColor) == true) {
			Image[x+1][y] = newColor.charAt(0);
			return true;
		}
		else if (fillRegion(Image, x, y+1, oldColor, newColor) == true) {
			Image[x][y+1] = newColor.charAt(0);
			return true;
		}
		else if (fillRegion(Image, x-1, y, oldColor, newColor) == true) {
			Image[x-1][y] = newColor.charAt(0);
			return true;
		}
		else if (fillRegion(Image, x, y-1, oldColor, newColor) == true) {
			Image[x][y-1] = newColor.charAt(0);
			return true;
		}
		else {
			return false;
		}
	}
}
