
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
public class TxtFiletoList
{
   public static int[] Hospitals() 
   {
       Scanner sc = new Scanner(new File("File2.txt"));
       ArrayList<String> list = new ArrayList<String>();
       while (sc.hasNext()){
            list.add(sc.next());
       }
       sc.close();
       String[] arr = new String[list.size()];
       arr = list.toArray(arr);
       int[] arrFinal = new int[arr.length-2];
       int k=0;
       for(int i=2; i<arr.length; i++)
       {       
           arrFinal[k] = Integer.parseInt(arr[i]);
           k++;
       }
       for(int i=0; i<arrFinal.length; i++)
       {
          System.out.print(arrFinal[i] + " ");
       }
      return arrFinal;
   }
}
