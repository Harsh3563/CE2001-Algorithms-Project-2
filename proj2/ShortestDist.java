package proj2;

import java.util.LinkedList;

public class ShortestDist {
	public static void BFStopk(Graph g, int s, int[] h, int nodes, int k) {
		LinkedList<Integer> L = new LinkedList<Integer>();
		L.add(s);
		boolean visited[] = new boolean[nodes];
		int dist = 0;
		int u;
		int[] children;
		int j, count = 0;
		int visitCount;
		int[] distances = new int[nodes];
		int[] hosp = new int[k];
		for (j = 0; j<h.length; j++) {
        	if (s == h[j]) {
        		distances[count] = dist;
        		count++;
        		if(count == k) {
					System.out.print("Distances are: ");
					for(int z = 0; z < count; z++) {
						System.out.print(hosp[z]+ " ");
					}
					System.out.println();
					return;
				}
        	}
        }
		dist++;
		
		for (int i = 0; i < nodes; i++) {
			visited[i] = false;
			//dist[i] = Integer.MAX_VALUE;
		}
		
		visited[s] = true;
		distances[s] = 0;
		while (!L.isEmpty()) { 
            u = L.remove();
            visitCount = 0;
            children = g.findChild(u);
            
	    for (int i = 0; i < g.findDegree(u); i++) { 

		if (visited[children[i]] == false) { 
		    visited[children[i]] = true; 
		    distances[children[i]] = distances[u] + 1;
		    L.add(children[i]); 


		    // stopping condition (when we find 
		    // our destination) 
	    for (j = 0; j<h.length; j++) {
				if (children[i] == h[j]){ 
					hosp[count] = distances[children[i]];
					count++;
					if(count == k) {
						System.out.print("Distances are: ");
						for(int z = 0; z < count; z++) {
							System.out.print(hosp[z]+ " ");
						}
						System.out.println();
						return;
					}
			    }
			}
		}
		else visitCount++;
	    } 
	    if(g.findDegree(u) > visitCount)
	    	dist++;
        }
		if(count == 0) {
			System.out.println("No hospitals connected to source node");
		}
	}
}
