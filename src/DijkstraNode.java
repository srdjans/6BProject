/**
 * 
 * This class represents a single Dijkstra node.
 * 
 * @author Srdjan Stojcic
 * @version 12.03.2013
 */
public class DijkstraNode {
	
	/**
	 * The value of this node
	 */
	private int value;
	
	/**
	 * The position of this node.
	 */
	private int position;
	
	/**
	 * Creates a single Dijkstra node with the given information.
	 * 
	 * @param value
	 * @param position
	 */
	public DijkstraNode(int value, int position) {
		this.value = value;
		this.position = position;
	}
}
