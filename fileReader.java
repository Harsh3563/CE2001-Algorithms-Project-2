package proj2;

import java.io.*;
import java.util.Scanner;

public class fileReader {
	public static void readGraphFromFile(String fileName, Graph graph) throws FileNotFoundException{
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
		graph = new Graph(numOfNodes*10);
		while(sc.hasNextLine()) {
			fromNode = sc.nextInt();
			toNode = sc.nextInt();
			//System.out.println("fromNode: " + fromNode + "\ntoNode:" + toNode); //For Checking purposes
			graph.addEdge(fromNode, toNode);
			sc.nextLine();
		}
				
		sc.close();
	}
	
	public static void main(String[] args) {
		Graph g;
		try {
		readGraphFromFile("roadNet-PA.txt", g);
		}
		catch(Exception FileNotFoundException) {
			System.out.println("File not found!");
		}
	}
}
