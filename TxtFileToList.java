import java.util.Scanner;
import java.io.File;
public class TxtFileToList { 
    public static void main(String[] args) { 
        try {
            Scanner scanner = new Scanner(new File("File2.txt"));
            int i=0,size=1;
            int arr[] = new int[size];
            while(scanner.hasNextInt())
            {
                arr[i++] = scanner.nextInt();
                size++;
            }
            for(i=0; i<size-1; i++)
            {
                System.out.print(arr[i] + " ");
            }
        }
        catch(Exception e) {
            System.out.println("File not Found!");
        }
        
    } 
}