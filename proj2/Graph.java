package proj2;


public class Graph {
	private int n;
	private int[][] adjMatrix;
	
	public Graph(int numOfNodes) {
		this.n = numOfNodes;
		adjMatrix = new int[n][n];
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				adjMatrix[i][j] = 0;
			}
		}
	}
	
	public int getSize() {
		return n;
	}
	
	public void addEdge(int fromNode, int toNode) {
		adjMatrix[fromNode][toNode] = 1;
	}
	
	public int findDegree(int node) {
		int degree = 0;
		for(int i = 0; i < n; i++) {
			if(adjMatrix[node][i] == 1) degree++;
		}
		return degree;
	}
	
	public int[] findChild(int node) {
		int[] childs = new int[n];
		int j = 0;
		for (int i = 0; i < n; i++) {
			if(adjMatrix[node][i] == 1) {
				childs[j] = i;
				j++;
			}
		}
		return childs;
	}
}
