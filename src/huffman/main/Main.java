package huffman.main;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

import huffman.algorithms.HuffmanAlgorithm;
import huffman.algorithms.entities.Node;

public class Main {
	
	public static void main(String[] args) {
		
		String gameName = "Forza Horizon";
		String serieName = "The Walking Dead";
		Node rootGame;
		Node rootSerie;
		
		// First transform the symbols into priorityqueue
		PriorityQueue<Node> priorityQueue1 = HuffmanAlgorithm.countFrequencies(gameName.toCharArray());
		PriorityQueue<Node> priorityQueue2 = HuffmanAlgorithm.countFrequencies(serieName.toCharArray());
		
		
		// Now generate the Huffman tree
		rootGame = HuffmanAlgorithm.mountHuffmanTree(priorityQueue1);
		rootSerie = HuffmanAlgorithm.mountHuffmanTree(priorityQueue2);
		
		// Fill codemap to transform tree into String of code
		Map<Character, String> resultGame = createCodeMap(rootGame);
		Map<Character, String> resultSerie = createCodeMap(rootSerie);
		
		
		StringBuilder stringBuilder = new StringBuilder();
		for(char symbol : gameName.toCharArray()){
			stringBuilder.append(resultGame.get(symbol));
		}
		
		String gameEncodedText = encodeText(resultGame, gameName.toCharArray());
		String serieEncodedText = encodeText(resultSerie, serieName.toCharArray());
		System.out.println(gameEncodedText);
		System.out.println(serieEncodedText);
	}

	
	private static Map<Character, String> createCodeMap(Node root){
		Map<Character, String> result = new TreeMap<>();
		
		root.fillCodeMap(result, "");
		return result;
	}
	
	private static String encodeText(Map<Character, String> result, char[] gameName){
		StringBuilder stringBuilder = new StringBuilder();
		for(char symbol : gameName){
			stringBuilder.append(result.get(symbol));
		}
		return stringBuilder.toString();
		
	}
	
}
