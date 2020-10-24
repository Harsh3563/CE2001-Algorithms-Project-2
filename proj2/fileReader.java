package proj2;

import java.io.*;
import java.util.Scanner;

public class fileReader {
	public static Graph readGraphFromFile(String fileName) throws FileNotFoundException{
		int numOfNodes, fromNode, toNode;
		File nodeFile = new File(fileName);
		Scanner sc = new Scanner(nodeFile);
		for(int i = 0; i < 2; i++) {
			sc.nextLine(); //Skip first 2 lines, unnecessary info
		}
		for(int i = 0; i < 2; i++) {
			sc.next(); //Remove "# Nodes:"
		}
		numOfNodes = sc.nextInt();
		//System.out.println(numOfNodes); For Checking purposes
		for(int i = 0; i < 2; i++) {
			sc.nextLine(); //Skip next 2 lines, unnecessary info
		}
		Graph graph = new Graph(numOfNodes*2);
		while(sc.hasNextLine()) {
			fromNode = sc.nextInt();
			toNode = sc.nextInt();
			//System.out.println("fromNode: " + fromNode + "\ntoNode:" + toNode); //For Checking purposes
			graph.addEdge(fromNode, toNode);
			sc.nextLine();
		}
		System.out.println("File has been read successfully, graph has been created.");
		
		sc.close();
		return graph;
	}
	
	public static void main(String[] args) {
		
		try {
		Graph g = readGraphFromFile("roadNet-PA.txt");
		}
		catch(Exception FileNotFoundException) {
			System.out.println("File not found!");
		}
	}
}