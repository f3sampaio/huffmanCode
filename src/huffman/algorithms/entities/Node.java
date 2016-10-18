package huffman.algorithms.entities;

import java.util.Map;

public class Node implements Comparable<Node>{
	
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
	
	// Constructor with left and right nodes, used to create parents
	public Node(Node left, Node right){
		this.symbol = '+';
		this.leftNode = left;
		this.rightNode = right;
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
	
    public void fillCodeMap(Map<Character, String> codemap, String work) {
        if (isLeaf()) {
            codemap.put(getSymbol(), work);
            return;
        }

        leftNode.fillCodeMap(codemap, work + "0");
        rightNode.fillCodeMap(codemap, work + "1");
    }
	
    public boolean isLeaf() {
        return leftNode == null && rightNode == null;
    }

	@Override
	public int compareTo(Node o) {
		return getFrequency() - o.getFrequency();
	}
	
	public int getFrequency() {
        if (isLeaf())
            return timesRepeated;
        return leftNode.getFrequency() + rightNode.getFrequency();
    }
}
