import java.util.ArrayList; 
import java.util.Iterator; 
import java.util.LinkedList; 
import java.util.Queue; 


public class pathUnweighted {
	int BFS(graph g, int s, int[] h, int nodes) {
		LinkedList<Integer> L = new LinkedList<Integer>();
		L.add(s);
		boolean visited[] = new boolean[nodes];
		int dist[] = new int[nodes];
		visited[s] = true;
		dist[s] = 0;
		
		for (int i = 0; i < nodes; i++) {
			visited[i] = false;
			dist[i] = Integer.MAX_VALUE;
		}
		
		while (!L.isEmpty()) { 
            int u = L.remove(); 
            for (int i = 0; i < g.findDegree(u); i++) { 
                if (visited[g.adjMatrix[u][i]] == false) { 
                    visited[g.adjMatrix[u][i]] = true; 
                    dist[g.adjMatrix[u][i]] = dist[u] + 1; 
                    // pred[g.get(u).get(i)] = u; 
                    L.add(g.adjMatrix[u][i]); 
  
                    // stopping condition (when we find 
                    // our destination) 
                    for (i = 0; i<h.length; i++)
                    	if (g.adjMatrix[u][i] == h[i]) 
                    		return dist[u]; 
                } 
            } 
        } 
	}
}