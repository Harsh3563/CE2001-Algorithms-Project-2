package proj2;

import java.util.LinkedList;

public class Graph {
	
	private int n;
	private LinkedList<Integer> adjList[];
	
	//Graph Constructor
	public Graph(int numOfNodes) { 
		this.n = numOfNodes;
		adjList = new LinkedList[n];
		for(int i= 0; i < n; i++) {
			adjList[i] = new LinkedList(); //Each node will have their own linked list 
		}
	}
	
	
	public int getSize() {
		return n;
	}
	
	//method to add edges
	public void addEdge(int fromNode, int toNode) {
		adjList[fromNode].add(toNode);
		adjList[toNode].add(fromNode);
		
	}

	//returns number of edges of a node
	public int findDegree(int nodeID) {

		return adjList[nodeID].size();
	}
	
	//returns all children of a node in an array
	public int[] findChild(int node) {
		int size = findDegree(node);
		int[] childs = new int[size];
		for (int i = 0; i < size; i++) {
			childs[i] = adjList[node].get(i);
		}
		return childs;

	}
}
