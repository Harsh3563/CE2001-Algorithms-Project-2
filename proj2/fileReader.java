package proj2;

import java.io.*;
import java.util.Scanner;

public class fileReader {
	public static Graph readGraphFromFile(String fileName) throws FileNotFoundException{
		int fromNode, toNode, max = 0;
		File nodeFile = new File(fileName);
		Scanner sc = new Scanner(nodeFile);
		for(int i = 0; i < 4; i++) {
			sc.nextLine(); //Skip first 4 lines, unnecessary info
		}
		
		try {
			while(sc.hasNextLine()) {
				fromNode = sc.nextInt();
				if(max < fromNode) max = fromNode;
				toNode = sc.nextInt();
				if(max < toNode) max = toNode;
				sc.nextLine();
			}
		}
		catch(Exception e){
			System.out.println("Error finding max node ID");
		}
		sc.close();
		Scanner newSc = new Scanner(nodeFile);
		
		Graph graph = new Graph(max+1);
		for(int i = 0; i < 4; i++) {
			newSc.nextLine(); //Skip first 4 lines, unnecessary info
		}
		
		try {
			while(newSc.hasNextLine()) {
				fromNode = newSc.nextInt();
				toNode = newSc.nextInt();
				//System.out.println("fromNode: " + fromNode + "\ntoNode:" + toNode); //For Checking purposes
				graph.addEdge(fromNode, toNode);
				newSc.nextLine();
			}
		}
		catch(Exception e){
			System.out.println("File has been read successfully, graph has been created.");
		}
		newSc.close();
		return graph;
		
	}
	
}
