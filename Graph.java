package proj2;


import java.util.LinkedList;

public class Graph {
	private int n;
	private LinkedList<Integer> adjList[];
	
	public Graph(int numOfNodes) {
		this.n = numOfNodes;
		adjList = new LinkedList[n];
		for(int i= 0; i < n; ++i) {
			adjList[i] = new LinkedList<Integer>();
		}
	}
	
	public void addEdge(int fromNode, int toNode) {
		adjList[fromNode].add(toNode);
	}
	

}
