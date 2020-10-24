package proj2;

import java.util.LinkedList; 



public class pathUnweighted {
	public static int BFS(Graph g, int s, int[] h, int nodes) {
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
		return -1;
	}
	
	public static int[] BFStopk(Graph g, int s, int[] h, int nodes, int k) {
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
		int j, count = 0;
		int[] distances = new int[nodes];
		
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
                    		distances[count] = dist;
                    		count++;
                    		if(count == k) {
                    			return distances;
                    		}
                    }
                } 
            } 
            dist++;
        }
		return distances;
	}
}