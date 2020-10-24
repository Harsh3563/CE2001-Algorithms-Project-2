package proj2;

import java.util.LinkedList;

public class Graph {
	
	private int n;
	private LinkedList<Integer> adjList[];
	
	public Graph(int numOfNodes) {
		this.n = numOfNodes;
		adjList = new LinkedList[n];
		for(int i= 0; i < n; ++i) {
			adjList[i] = new LinkedList();
		}
	}
	
	public int getSize() {
		return n;
	}
	
	public void addEdge(int fromNode, int toNode) {
		adjList[fromNode].add(toNode);
		
	}

	
	public int findDegree(int nodeID) {

		return adjList[nodeID].size();
	}
	
	public int[] findChild(int node) {
		int size = findDegree(node);
		int[] childs = new int[size];
		for (int i = 0; i < size; i++) {
			childs[i] = adjList[node].get(i);
		}
		return childs;

	}
}
