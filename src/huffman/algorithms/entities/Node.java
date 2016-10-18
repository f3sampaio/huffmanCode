package huffman.algorithms.entities;

public class Node {
	
	private char symbol;
	private int timesRepeated;
	private Node leftNode;
	private Node rightNode;
	
	// Empty Constructor
	public Node(){
		
	}
	
	// Constructor with symbol parameter
	public Node(char symbol){
		this.symbol = symbol;
	}

	public char getSymbol() {
		return symbol;
	}

	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}

	public int getTimesRepeated() {
		return timesRepeated;
	}

	public void setTimesRepeated(int timesRepeated) {
		this.timesRepeated = timesRepeated;
	}

	public Node getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(Node leftNode) {
		this.leftNode = leftNode;
	}

	public Node getRightNode() {
		return rightNode;
	}

	public void setRightNode(Node rightNode) {
		this.rightNode = rightNode;
	}

	public void increment() {
		this.timesRepeated++;
		
	}
	
	
	
}
