import java.util.*;
import java.io.*;


public class Minimum_Number {
	public static void main(String [] args){

        //Scanner
        Scanner s = new Scanner(System.in);
        String testCases = s.nextLine();                 // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT
		int test = Integer.parseInt(testCases);
		while(test){
			String kString = s.nextLine(); 
			int k = Integer.parseInt(k);
			System.out.println(findMinNumber(k));
			test--;
		}

	}

}