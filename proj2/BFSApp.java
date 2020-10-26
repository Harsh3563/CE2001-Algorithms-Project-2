package proj2;

import java.util.Scanner;

public class BFSApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int choice, sourceNode, dist, k;
		int[] h = null;
		Graph g = null;
		boolean demo = true;
		long startTime;
		
		//Graph g = new Graph(10);
		
		try {
			g = fileReader.readGraphFromFile("roadNet-PA.txt"); //Change Node file name here
			}
		catch(Exception FileNotFoundException) {
				System.out.println("File not found!");
				System.exit(0);
			}
		/*
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 3);
		g.addEdge(1, 4);
		g.addEdge(2, 5);
		g.addEdge(2, 6);
		g.addEdge(3, 7);
		g.addEdge(3, 8);
		g.addEdge(4, 9);
		*/
		
		try {
			h = TxtFiletoList.Hospitals("Case2Hosp.txt"); //Change Hospital file name here
		}
		catch(Exception FileNotFoundException) {
			System.out.println("Hospital File not found");
			System.exit(0);
		}
		
		
		Scanner sc = new Scanner(System.in);
		
		
		do {
			System.out.println("Select which algorithm to find:\n"
					+ "[1] Nearest Hospital\n"
					+ "[2] Top 2 Hospitals\n"
					+ "[3] Top-k Hostpitals\n"
					+ "[4] Quit");
			choice = sc.nextInt();
			if(choice == 4) break;
			System.out.print("Enter source node ID:");
			sourceNode = sc.nextInt();
			switch(choice) {
			case 1:
				try {
					startTime = System.nanoTime();
					ShortestDist.BFStopk(g, sourceNode, h, g.getSize(), 1);
					System.out.println("Time taken: " + (System.nanoTime() - startTime) + "nanoseconds");
				}
				catch(Exception e) {
					System.out.println("An error has occurred");
				}
				break;
			case 2:
				try {
					startTime = System.nanoTime();
					ShortestDist.BFStopk(g, sourceNode, h, g.getSize(), 2);
					System.out.println("Time taken: " + (System.nanoTime() - startTime) + "nanoseconds");
				}
				catch(Exception e) {
					System.out.println("An error has occurred");
				}
				break;
			case 3:
				System.out.println("Enter desired k value: ");
				k = sc.nextInt();
				try {
					startTime = System.nanoTime();
					ShortestDist.BFStopk(g, sourceNode, h, g.getSize(), k);
					System.out.println("Time taken: " + (System.nanoTime() - startTime) + "nanoseconds");
				}
				catch(Exception e) {
					System.out.println("An error has occurred");
				}
				break;
			default:
				System.out.println("Not a valid option");
				break;
			}
		}while(demo);
		System.out.println("Program completed!");
		sc.close();
	}

}
