package proj2;

import java.util.LinkedList; 

public class pathUnweighted {
	public static int BFS(Graph g, int s, int[] h, int nodes) {
		LinkedList<Integer> L = new LinkedList<Integer>();
		L.add(s);
		boolean visited[] = new boolean[nodes];
		int dist = 0;
		int u;
		int[] children;
		int j;
		for (j = 0; j<h.length; j++) {
        	if (s == h[j]) 
        		return dist; 
        }
		dist++;
		
		//int dist[] = new int[nodes];
		//dist[s] = 0;
		
		for (int i = 0; i < nodes; i++) {
			visited[i] = false;
			//dist[i] = Integer.MAX_VALUE;
		}
		visited[s] = true;
		int truecounter;
		
		while (!L.isEmpty()) { 
            u = L.remove(); 
            children = g.findChild(u);
            truecounter = 0;
            
            for (int i = 0; i < g.findDegree(u); i++) { 
            	
            	if (visited[children[i]] == true)
            		truecounter = truecounter + 1;
            	
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
            if (truecounter < g.findDegree(u))
            	dist++;
        }
		return -1;
	}
	
	public static int[] BFStopk(Graph g, int s, int[] h, int nodes, int k) {
		LinkedList<Integer> L = new LinkedList<Integer>();
		L.add(s);
		boolean visited[] = new boolean[nodes];
		int dist = 0;
		int u;
		int[] children;
		int j, count = 0;
		int[] distances = new int[nodes];
		for (j = 0; j<h.length; j++) {
        	if (s == h[j]) {
        		distances[count] = dist;
        		count++;
        	}
        }
		dist++;
		//int dist[] = new int[nodes];
		//dist[s] = 0;
		
		for (int i = 0; i < nodes; i++) {
			visited[i] = false;
			//dist[i] = Integer.MAX_VALUE;
		}
		
		visited[s] = true;
		
		
		while (!L.isEmpty()) { 
            u = L.remove(); 
            if(g.findDegree(u) != 0) {
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
	                    			System.out.print("Distances are: ");
	                    			for(int z = 0; z < count; z++) {
	                    				System.out.print(distances[z]+ ", ");
	                    			}
	                    			System.out.println();
	                    			return distances;
	                    		}
	                    }
	                } 
	            } 
	            dist++;
            }
        }
		return distances;
	}
	
}