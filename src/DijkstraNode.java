/**
 * 
 * This class represents a single Dijkstra node.
 * 
 * @author Srdjan Stojcic, My Hoang
 * @version 12.03.2013
 */
public class DijkstraNode implements Comparable {
	
	/**
	 * The value of this node
	 */
	private int my_value;
	
	/**
	 * The position in the heap of this node
	 */
	private int my_position;
	
	/**
	 * The vertex
	 */
	private Vertex my_vertex;
	
	/**
	 * The previous node 
	 */
	private DijkstraNode my_previous_node;
	
	/**
	 * Creates a single Dijkstra node with the given information.
	 * 
	 * @param the_vertex The vertex of the node
	 * @param the_value The value of the node
	 * @param the_previous The previous node leading to this node
	 */
	public DijkstraNode(Vertex the_vertex, int the_value, DijkstraNode the_previous) {
		this.my_value = the_value;
		this.my_vertex = the_vertex;
		this.my_previous_node = the_previous;
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
		if(my_vertex.hashCode() - o.hashCode() > 0) {
			return 1;
		}
		else if (my_vertex.hashCode() - o.hashCode() < 0) {
			return -1;
		}
		return 0;
	}
	
	/**
	 * Returns this node's value
	 * 
	 * @return this node's value
	 */
	public int getValue() {
		return my_value;
	}
	
	/**
	 * Returns this node's position
	 * 
	 * @return this node's position
	 */
	public int getPosition() {
		return my_position;
	}
	
	/**
	 * Return this Vertex
	 * 
	 * @return this vertex
	 */
	public Vertex getVertex() {
		return my_vertex;
	}
	
	/**
	 * Return the previous node
	 * 
	 * @return the previous node 
	 */
	public DijkstraNode getPrevious() {
		return my_previous_node;
	}
	
	/**
	 * Set the new value
	 * 
	 * @param the_value The new value of this Node.
	 */
	public void setValue(int the_value) {
		this.my_value = the_value;
	}
	
	/**
	 * Set a new previous node
	 * 
	 * @param the_node The new previous node
	 */
	public void setPrevious(DijkstraNode the_node) {
		this.my_previous_node = the_node;
	}
}
