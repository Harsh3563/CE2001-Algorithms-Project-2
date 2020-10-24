package proj2;

import java.util.Scanner;

public class BFSApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int choice, sourceNode, dist, k;
		int[] h = null;
		Graph g = null;
		int[] distances;
		boolean repeat = true;
		
		try {
			g = fileReader.readGraphFromFile("roadNet-PA.txt");
			}
		catch(Exception FileNotFoundException) {
				System.out.println("File not found!");
			}
		
		try {
			h = TxtFiletoList.Hospitals();
		}
		catch(Exception FileNotFoundException) {
			System.out.println("Hospital File not found");
		}
		
		if((g == null)||(h == null)){
			System.out.println("Error with files");
			System.exit(0);
		}
		
		Scanner sc = new Scanner(System.in);
		
		while(repeat) {
			System.out.println("Select which algorithm to find:\n"
					+ "[1] Nearest Hospital\n"
					+ "[2] Top 2 Hospitals\n"
					+ "[3] Top-k Hostpitals\n"
					+ "[4] Quit");
			choice = sc.nextInt();
			System.out.print("Enter source node ID:");
			sourceNode = sc.nextInt();
			switch(choice) {
			case 1:
				dist = pathUnweighted.BFS(g, sourceNode, h, g.getSize());
				System.out.println("Distance to nearest hospital is:" + dist);
				break;
			case 2:
				distances = pathUnweighted.BFStopk(g, sourceNode, h, g.getSize(), 2);
				break;
			case 3:
				System.out.println("Enter desired k value: ");
				k = sc.nextInt();
				distances = pathUnweighted.BFStopk(g, sourceNode, h, g.getSize(), k);
				break;
			case 4:
				repeat = false;
				break;
			default:
				System.out.println("Not a valid option");
				break;
			}
		}
		System.out.println("Program completed!");
	}

}
