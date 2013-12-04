import java.util.Arrays;

/**
 * 
 *
 */
public class DijkstraMinHeap {
    private static final int INITIAL_SIZE = 20;
    protected DijkstraNode[] data;
    protected int size;
    
    /**
     * Constructs a new DijkstraMinHeap
     * @return 
     */
	public DijkstraMinHeap () {
        data = (DijkstraNode[])new Comparable[INITIAL_SIZE];  
        size = 0;
    }
    
    
    /**
     * Adds a value to the min-heap.
     */
    public void add(DijkstraNode value) {
        if (size > data.length) {
            grow();
        }        
        
        size++;
        int index = size;
        data[index] = value;
        
        percolateUp(size);
    }
    
    
    /**
     * Returns true if this heap is empty and false otherwise.
     * 
     * @return Whether this heap is empty.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    
    /**
     * Returns the node at the head of the heap (node with smallest value).
     * Note: This method does not remove the node from the heap.
     * 
     * @return The node with smallest value.
     */
    public DijkstraNode peek() {
    	DijkstraNode result = null;
        if (!isEmpty()) {
            result = data[1];
        }
        return result;
    }

    
    /**
     * Removes the head node of this heap (node with smallest value).
     * 
     * @return The node being removed
     */
    public DijkstraNode remove() {
    	DijkstraNode result = peek();
    	
    	data[1] = data[size];
    	data[size] = null;
    	size--;
    	
    	percolateDown(1);
    	
    	return result;
    }
    
    
    /**
     * Returns a String representation of this heap.
     * 
     * @return String representation of this heap
     */
    public String toString() {
        return Arrays.toString(data);
    }

    
    /**
     * Percolates down the node at the given index.
     * 
     * @param i The index of the node to percolate down.
     */
    public void percolateDown(int i) {
        
        while (hasLeftChild(i)) {
            int smallerChild = leftChildIndex(i);
          
            if (hasRightChild(i)
                && data[rightChildIndex(i)].compareTo(data[leftChildIndex(i)]) < 0) {
                smallerChild = rightChildIndex(i);
            } 
            
            if (data[i].compareTo(data[smallerChild]) > 0) {
                swap(i, smallerChild);
            } else {
                break;
            }
            
            i = smallerChild;
        }        
    }
    
    
    /**
     * Percolates up the node at the given index.
     * 
     * @param i The index of the node to percolate up.
     */
    public void percolateUp(int i) {
        while (hasParent(i) && (parent(i).compareTo(data[i]) > 0)) {
            swap(i, parentIndex(i));
            i = parentIndex(i);
        }        
    }
    
    /**
     * Returns true if the child at the given index has a parent and false otherwise.
     * 
     * @param i The child's index.
     * @return Whether the child at the given index has a parent
     */
    public boolean hasParent(int i) {
        return data[parentIndex(i)] == null;
    }
    
    /**
     * Returns the index of the left child of the node at the given index.
     * 
     * @param i The index of the parent node.
     * @return The index of the left child of the parent node at index i.
     */
    public int leftChildIndex(int i) {
        return i * 2;
    }
    
    /**
     * Returns the index of the right child of the node at the given index.
     * 
     * @param i The index of the parent node.
     * @return The index of the right child of the parent node at index i.
     */
    public int rightChildIndex(int i) {
        return i * 2 + 1;
    }
    
    /**
     * Returns true if the node at the given index has a left child and false otherwise.
     * 
     * @param i The index of the node to examine.
     * @return Whether the node at the given index has a left child.
     */
    public boolean hasLeftChild(int i) {
        return data[leftChildIndex(i)] == null;
    }
    
    /**
     * Returns true if the node at the given index has a right child and false otherwise.
     * 
     * @param i The index of the node to examine.
     * @return Whether the node at the given index has a right child.
     */
    public boolean hasRightChild(int i) {
        return data[rightChildIndex(i)] == null;
    }
    
    /**
     * Returns the parent node of the node at the given index.
     * 
     * @param i The index of the node to return the parent of
     * @return The parent node of the node at index i
     */
    public DijkstraNode parent(int i) {
        return data[parentIndex(i)];
    }
    
    /**
     * Returns the parent index of the node at the given index.
     * 
     * @param i The node to find parent index of
     * @return The parent index of node i
     */
    public int parentIndex(int i) {
        return i / 2;
    }
    
    
    /**
     * Grows the data array of this heap.
     */
    public void grow() {
        data = Arrays.copyOf(data, data.length * 2);
    }
    
    /**
     * Swaps the two nodes at given indices. 
     * 
     * @param index1 First index to swap.
     * @param index2 Second index to swap.
     */
    public void swap(int index1, int index2) {
        DijkstraNode temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;        
    }
}