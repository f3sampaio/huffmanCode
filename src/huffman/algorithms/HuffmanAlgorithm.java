package huffman.algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import huffman.algorithms.entities.Node;

public abstract class HuffmanAlgorithm {
	
	/**
	 * This method counts the number of times a character present in the array occurres
	 * and priorize it into a priority queue.
	 * @param letters: Array of chars
	 * @return A priority Queue containing the nodes in ascending order of frequency.
	 */
	public static PriorityQueue<Node> countFrequencies(char[] arrayOfSymbols){
		Map<Character, Node> count = new HashMap<>();
		
		// Each symbol is put into hashmap if isnt already into it
		for(char character : arrayOfSymbols){
			if(!count.containsKey(character)){
				count.put(character, new Node(character)); 
			} else {
				// Symbol is already on the hashmap, so increment his counter attribute 
				count.get(character).increment();
			}
 		}
		
		return new PriorityQueue<>(count.values());
		
	}
	
	/**
	 * This method creates the huffman tree grouping the first two elements into a parent
	 * while the priority queue isnt empty
	 * @param nodes Nodes into a priorityQueue
	 * @return Huffman tree
	 */
	public static Node mountHuffmanTree(PriorityQueue<Node> nodes) {
		Node firstNode = null;
		Node secondNode = null;;
		Node parent = null;
		
		while(!nodes.isEmpty()){
			
			// Group the two lowest frequent nodes
			firstNode = nodes.poll();
			secondNode = nodes.poll();
			parent = new Node(firstNode, secondNode);
			
			if(!nodes.isEmpty()){
				nodes.add(parent);
			} else {
				// Do nothing
			}
		}
		
		
		return parent;
	}

	
}
