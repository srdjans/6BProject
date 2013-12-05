import java.util.Hashtable;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

/**
 * This class implements Dijkstra's algorithm to find the shortest path
 * between two cities. 
 * 
 * @author Srdjan Stojcic, My Hoang, Peter Pentescu
 * @version 12.4.2013
 *
 */
public class Dijkstra {
	
	/**
	 * Private constructor to avoid instantiation.
	 */
	private Dijkstra() {
		// nothing to do here
	}
	
	/**
	 * Finds the shortest path from a vertex to another vertex.
	 * 
	 * @param args Command line parameters (Ignored).
	 */
	public static void main(String[] args) {
		SimpleGraph graph = new SimpleGraph();
		Hashtable table = GraphInput.LoadSimpleGraph(graph);
		BinaryHeap heap = new BinaryHeap();
		
		Scanner reader = new Scanner(System.in);
		String origin,destination,repeat;
		boolean again = true;
		
		while(again) {
			System.out.println("Please enter the name of the starting location:");
			origin = reader.nextLine();
			System.out.println("Please enter the name of the destination:");
			destination = reader.nextLine();
			
			initializeNodes(graph, heap);
			
			DijkstraNode start = (DijkstraNode) ((Vertex)table.get(origin)).getData();
			DijkstraNode finish = (DijkstraNode) ((Vertex)table.get(destination)).getData(); 
			
			// Find the shortest paths to all vertices from the starting location
			dijkstra(start, graph, heap);

			printResults(finish);
			
			System.out.println("Would you like to go again? yes/no");
			repeat = reader.nextLine();
			while (!repeat.equals("yes") && !repeat.equals("no")) {
				System.out.println("Invalid input, please try again.");
				repeat = reader.nextLine();
			}	
			again = repeat.equals("yes");
		}
	}
	
	/**
	 * Prints the resulting path in correct order.
	 * 
	 * @param finish The destination node used to backtrack the path.
	 */
	private static void printResults(DijkstraNode finish) {
		if(finish.getValue() < Double.MAX_VALUE) {
			Stack<Vertex> stack = new Stack<Vertex>();
			
			DijkstraNode temp = finish;
			while(temp != null) {
				stack.push(temp.getVertex());
				temp = temp.getPrevious();
			}
			
			System.out.print("Shortest path: ");
			while(stack.size() > 1) {
				System.out.print(stack.pop().getName() + ", ");
			}
			System.out.print(stack.pop().getName() + ".\n");
			
			System.out.println("The length of the path is: " + finish.getValue());
		} else {
			System.out.println("No path found.");
		}
	}

	/**
	 * Initialize all nodes and add them into the heap.
	 * 
	 * @param graph The graph that contains the vertices used to initialize the nodes.
	 * @param heap The heap to add the nodes into.
	 */
	private static void initializeNodes(SimpleGraph graph, BinaryHeap heap) {
		Iterator vertices = graph.vertices();
		while (vertices.hasNext()) {
			Vertex v = (Vertex) vertices.next();
			DijkstraNode node = new DijkstraNode(v, Double.MAX_VALUE, null);
			v.setData(node);
			heap.insert(node);
		}
	}
	
	/**
	 * Uses the Dijkstra algorithm to find the shortest path in the given graph, starting at the given node,
	 * implemented using a heap.
	 * 
	 * @param origin The starting location
	 * @param graph The graph used to find the shortest path
	 * @param heap A heap of nodes used in the algorithm
	 */
	public static void dijkstra(DijkstraNode origin, SimpleGraph graph, BinaryHeap heap) {
		origin.setValue(0);
		heap.percolateUp(origin.getPosition());
		
		while(true) {
			DijkstraNode dnode = (DijkstraNode)heap.deleteMin();
			
			if (dnode == null) {
				break;
			}
			
			dnode.setKnown(true);
			
			Vertex v1 = dnode.getVertex();
			Iterator edges = graph.incidentEdges(v1);
			
			while (edges.hasNext()) {
				Edge edge = (Edge)edges.next();
				if(edge.getFirstEndpoint().equals(v1)) {
					Vertex otherVertex = graph.opposite(v1, edge);
				
					if (!((DijkstraNode)otherVertex.getData()).isKnown()) {
						if (dnode.getValue() + (Double)edge.getData() < ((DijkstraNode)otherVertex.getData()).getValue()) {
							((DijkstraNode)otherVertex.getData()).setValue(dnode.getValue() + (Double)edge.getData());
							heap.percolateUp(((DijkstraNode)otherVertex.getData()).getPosition());
							((DijkstraNode)otherVertex.getData()).setPrevious(dnode);
						}
					}
				}	
			}	
		}
	}
}
