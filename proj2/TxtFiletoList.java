package proj2;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class TxtFiletoList
{
   public static int[] Hospitals(String file) throws FileNotFoundException // Takes in the filename as method argument
   {
       Scanner sc = new Scanner(new File(file));
       ArrayList<String> list = new ArrayList<String>(); 
       while (sc.hasNext()){ // while-loop to read in the values from the hospital file and store in the array list
            list.add(sc.next());
       }
       sc.close();
       String[] arr = new String[list.size()];
       arr = list.toArray(arr); // string array stores the values in the array list as string variables
       int[] arrFinal = new int[arr.length-2]; // integer array to store the hospitals' node IDs in the string array as integers
       int k=0;
       for(int i=2; i<arr.length; i++) // for-loop ignores the 1st value of the string array, which is essentially the total no. of hospitals (since 'arrFinal' only stores the hospitals' node IDs) 
       {       
           arrFinal[k] = Integer.parseInt(arr[i]);
           k++;
       }
       
      return arrFinal;
   }
}
