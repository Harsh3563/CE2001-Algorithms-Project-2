package proj2;

import java.util.LinkedList;

public class BFSUndirected {
	public static int BFS(Graph g, int s, int[] h, int nodes) {
		LinkedList<Integer> L = new LinkedList<Integer>();
		L.add(s);
		boolean visited[] = new boolean[nodes];
		//int[] pre = new int[nodes];
		int[] dist = new int[nodes];
		int[] children = new int[nodes];
		int u;
		boolean connected;
		
		for (int i = 0; i < nodes; i++) {
			visited[i] = false;
			dist[i] = Integer.MIN_VALUE;
			//pre[i] = -1;
		}
		
		visited[s] = false;
		dist[s] = 0;
		
		while (L.isEmpty()==false) {
			u = L.remove();
			children = g.findChild(u);
			for (int i = 0; i<g.findDegree(u);i++) {
				if (visited[children[i]] == false) {
					visited[children[i]] = true;
					dist[children[i]] = dist[u] + 1;
					//pre[children[i]] = u;
					L.add(children[i]);
					
					for (int j = 0; j<h.length; j++) {
                    	if (children[i] == h[j]) {
                    		connected = true;
                    		return dist[h[j]];
                    		//break;
                    	}
					}
				}
			}
		}
		//if (connected == false)
		return -1;
		//else
		//	return dist[]
 	}
}
