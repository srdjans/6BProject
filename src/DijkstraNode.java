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
	private double my_value;
	
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
	 * The known flag for Dijkstra algorithm.
	 */
	private boolean known;
	
	/**
	 * Creates a single Dijkstra node with the given information.
	 * 
	 * @param the_vertex The vertex of the node
	 * @param the_value The value of the node
	 * @param the_previous The previous node leading to this node
	 */
	public DijkstraNode(Vertex the_vertex, double the_value, DijkstraNode the_previous) {
		this.my_value = the_value;
		this.my_vertex = the_vertex;
		this.my_previous_node = the_previous;
		this.known = false;
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
		return Double.compare(my_value, ((DijkstraNode)o).getValue());
	}
	
	/**
	 * Returns this node's value
	 * 
	 * @return this node's value
	 */
	public double getValue() {
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
	 * Sets this node's position.
	 */
	public void setPosition(int position) {
		my_position = position;
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
	public void setValue(double the_value) {
		this.my_value = the_value;
	}
	
	/**
	 * Returns true if this node is known and false otherwise
	 * 
	 * @return Whether this node has been marked as known.
	 */
	public boolean isKnown() {
		return known;
	}
	
	/**
	 * Set the known flag for this node.
	 */
	public void setKnown(boolean b) {
		known = b;
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
