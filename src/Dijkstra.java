import java.util.Hashtable;
import java.util.Scanner;

/**
 * This class implements Dijkstra's algorithm to find the shortest path
 * between two cities. 
 * 
 * @author Srdjan Stojcic
 * @version 12.3.2013
 *
 */
public class Dijkstra {
	
	/**
	 * Private constructor to avoid instantiation.
	 */
	private Dijkstra() {
		// nothing to do here
	}
	
	
	public static void main(String[] args) {
		SimpleGraph graph = new SimpleGraph();
		Hashtable table = GraphInput.LoadSimpleGraph(graph);
		
		Scanner reader = new Scanner(System.in);
		String origin,destination,repeat;
		boolean again = true;
		
		while(again) {
			System.out.println("Please enter the name of the starting location:");
			origin = reader.nextLine();
			System.out.println("Please enter the name of the destination:");
			destination = reader.nextLine();
			
			// call to dijkstra method here
			
			System.out.println("Would you like to go again? yes/no");
			repeat = reader.nextLine();
			while (!repeat.equals("yes") && !repeat.equals("no")) {
				System.out.println("Invalid input, please try again.");
				repeat = reader.nextLine();
			}	
			again = repeat.equals("yes");
		}
	}
}
