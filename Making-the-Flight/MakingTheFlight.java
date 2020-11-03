import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MakingTheFlight {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner ns = new Scanner(new File("n.in"));
		int numCases = ns.nextInt(); ns.nextLine();
		for (int x = 1; x <= numCases; x++) {
			TimeFormat arrival, departure;
			String line = ns.nextLine(); line = line.replaceAll(":", " ");
			Scanner lr = new Scanner(line);
			arrival = new TimeFormat(lr.nextInt(), lr.nextInt());
			line = ns.nextLine(); line = line.replaceAll(":", " ");
			lr = new Scanner(line);
			departure = new TimeFormat(lr.nextInt(), lr.nextInt());
			line = ns.nextLine(); line = line.replaceAll("/", " ");
			lr = new Scanner(line);
			int time1 = lr.nextInt() * 5, time2 = lr.nextInt() * 3, time3 = lr.nextInt();
			
			TimeFormat.setTime(arrival, (time1+time2+time3));
			if (TimeFormat.compareTimes(arrival, departure)) {
				System.out.println("Case " + x + ": Yes" );
			}
			else {
				System.out.println("Case " + x + ": No" );
			}
		}
		
	}
	
}
