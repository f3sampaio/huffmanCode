package huffman.main;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

import huffman.algorithms.HuffmanAlgorithm;
import huffman.algorithms.entities.Node;

public class Main {
	
	private Node root;
	
	public static void main(String[] args) {
		
		String gameName = "Forza Horizon";
		String serieName = "The Walking Dead";
		
		PriorityQueue<Node> priorityQueue1 = HuffmanAlgorithm.countFrequencies(gameName.toCharArray());
		PriorityQueue<Node> priorityQueue2 = HuffmanAlgorithm.countFrequencies(serieName.toCharArray());
		
	}

	
	private Map<Character, String> createCodeMap(){
		Map<Character, String> result = new TreeMap<>();
		
		root.fillCodeMap(result, "");
		return result;
	}
}
