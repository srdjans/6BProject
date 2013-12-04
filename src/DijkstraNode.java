/**
 * 
 * This class represents a single Dijkstra node.
 * 
 * @author Srdjan Stojcic
 * @version 12.03.2013
 */
public class DijkstraNode implements Comparable {
	
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

	/**
	 * Compares this DijkstraNode to another.
	 * 
	 * @param o The other node
	 * @return a positive integer, zero, or a negative integer as this object is greater than, 
	 * 		   equal to, or less than the given object.
	 */
	@Override
	public int compareTo(Object o) {
		return this.value - ((DijkstraNode)o).getValue();
	}
	
	/**
	 * Returns this node's value
	 * 
	 * @return this node's value
	 */
	public int getValue() {
		return value;
	}
	
	/**
	 * Returns this node's position
	 * 
	 * @return this node's position
	 */
	public int getPosition() {
		return position;
	}
}
