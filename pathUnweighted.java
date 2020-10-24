import java.util.ArrayList; 
import java.util.Iterator; 
import java.util.LinkedList; 
import java.util.Queue; 


public class pathUnweighted {
	int BFS(Graph g, int s, int[] h, int nodes) {
		LinkedList<Integer> L = new LinkedList<Integer>();
		L.add(s);
		boolean visited[] = new boolean[nodes];
		int dist = 0;
		visited[s] = true;
		//int dist[] = new int[nodes];
		//dist[s] = 0;
		
		for (int i = 0; i < nodes; i++) {
			visited[i] = false;
			//dist[i] = Integer.MAX_VALUE;
		}
		
		int u;
		int[] children;
		int j;
		
		while (!L.isEmpty()) { 
            u = L.remove(); 
            children = g.findChild(u);
            for (int i = 0; i < g.findDegree(u); i++) { 
          
                if (visited[children[i]] == false) { 
                    visited[children[i]] = true; 
                    
                    //dist[children[i]] = dist[u] + 1; 
                    //pred[g.get(u).get(i)] = u; 
                    L.add(children[i]); 
  
                    // stopping condition (when we find 
                    // our destination) 
                    for (j = 0; j<h.length; j++) {
                    	if (children[i] == h[j]) 
                    		return dist; 
                    }
                } 
            } 
            dist++;
        } 
	}
}