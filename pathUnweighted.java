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
            for (int i = 0; i < g.get(u).size(); i++) { 
                if (visited[g.get(u).get(i)] == false) { 
                    visited[g.get(u).get(i)] = true; 
                    dist[g.get(u).get(i)] = dist[u] + 1; 
                    // pred[g.get(u).get(i)] = u; 
                    L.add(g.get(u).get(i)); 
  
                    // stopping condition (when we find 
                    // our destination) 
                    for (i = 0; i<h.length; i++)
                    	if (g.get(u).get(i) == h[i]) 
                    		return dist[u]; 
                } 
            } 
        } 
	}
}