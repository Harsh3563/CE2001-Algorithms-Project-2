package proj2;

import java.util.LinkedList;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

public class ShortestDist {
	public static void BFStopk(Graph g, int s, int[] h, int nodes, int k) throws IOException {
		LinkedList<Integer> L = new LinkedList<Integer>();	//linkedlist queue for nodes to visit
		L.add(s);
		boolean visited[] = new boolean[nodes];			//array of all nodes, true or false for visited
		int u;
		int[] children;
		int j, count = 0;
		int[] distances = new int[nodes];			//array keeping track of all distances of nodes from source
		int[] pre = new int[nodes];				//array keeping track of parent node for each node
		int[] hosp = new int[k];				//array of distances from connected h to source s
		int[] foundh = new int[k];				//array of connected h to source s
		
		File myObj = new File("output.txt");
		if (myObj.createNewFile()) {
			System.out.println("File created: " + myObj.getName());
		} 
		else {
			System.out.println("File already exists.");
		}

		FileWriter myWriter = new FileWriter("output.txt");
		
		for (j = 0; j<h.length; j++) {
        	if (s == h[j]) {
        		distances[count] = 0;
        		count++;
        		if(count == k) {
					System.out.print("Distances are: ");
					myWriter.write("Distances are: \n");
					for(int z = 0; z < count; z++) {
						System.out.print(hosp[z]+ " ");
						myWriter.write(hosp[z]+ " ");
					}
					System.out.println();
					myWriter.write("\n");
					return;
					}
        		}
        	}
			
			LinkedList<Integer> path[] = new LinkedList[k];		//path array: each element is path from one h to source s
			for (int o=0; o<k; o++) {
				path[o] = new LinkedList();
			}
			
			for (int i = 0; i < nodes; i++) {
				visited[i] = false;
				pre[i] = -1;
			}
			
			visited[s] = true;
			distances[s] = 0;
			while (!L.isEmpty()) { 
	            u = L.remove();					//remove node from queue to check children
	            children = g.findChild(u);
	            
			    for (int i = 0; i < g.findDegree(u); i++) { 
		
					if (visited[children[i]] == false) { 				//check if child node is not yet visited, 
					    visited[children[i]] = true; 				//then mark it as visited
					    distances[children[i]] = distances[u] + 1;			//distance of children to source node is parent+1
					    pre[children[i]] = u;
					    L.add(children[i]); 
		
				    
					    for (j = 0; j<h.length; j++) {
							if (children[i] == h[j]){ 				//check child match with element of h
								hosp[count] = distances[children[i]];
								foundh[count] = children[i];
								count++;
								if(count == k) {				//return condition if all hospitals are connected
									System.out.print("Distances are: ");
									myWriter.write("Distances are: \n");
									for(int z = 0; z < count; z++) {
										System.out.print(hosp[z]+ " ");
										myWriter.write(hosp[z]+ " ");
									}
									System.out.println();
									myWriter.write("\n");
	
									for (int q=0; q<count; q++) {		//construct path from h to source s
										int trace = foundh[q];
										path[q].add(trace);
										while (pre[trace] != -1) {
											path[q].add(pre[trace]);
											trace = pre[trace];
										}
										System.out.print("Path: "); 
										myWriter.write("Path: ");
								        for (int w = path[q].size() - 1; w >= 0; w--) { 
								            System.out.print(path[q].get(w) + " "); 
								            myWriter.write(path[q].get(w) + " ");
								        } 
								        System.out.println();
								        myWriter.write("\n");
									}
									myWriter.close();
									return;
								}
						    }
						}
					}
			    } 
		     }
			 if(count == 0) {
			 	System.out.println("No hospitals connected to source node");
			 	myWriter.write("No hospitals connected to source node\n");
			 }
			 else {
			 	System.out.println("Only " + count + " hospitals were found");
			 	System.out.print("Distances are: ");
			 	myWriter.write("Only " + count + " hospitals were found\n");
			 	myWriter.write("Distances are: ");
				for(int z = 0; z < count; z++) {
					System.out.print(hosp[z]+ " ");
					myWriter.write(hosp[z]+ " ");
				}
				System.out.println();
				myWriter.write("\n");
	
				for (int q=0; q<count; q++) {
					int trace = foundh[q];
					path[q].add(trace);
					while (pre[trace] != -1) {
						path[q].add(pre[trace]);
						trace = pre[trace];
					}
					System.out.print("Path: "); 
					myWriter.write("Path: ");
			        for (int i = path[q].size() - 1; i >= 0; i--) { 
			            System.out.print(path[q].get(i) + " "); 
			            myWriter.write(path[q].get(i) + " ");
			        }
			        System.out.println();
			        myWriter.write("\n");
				}
			}
		myWriter.close();
	}
}
