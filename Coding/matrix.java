/*
2 5 3
1 3 3 4 1
2 1 1 3 4

*/

import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class matrix {

	public static void main(String args[]){
		try{
	  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String name = br.readLine(); 
        String [] v1 = name.split(" ");


        int n = Integer.parseInt(v1[0]);
        int m = Integer.parseInt(v1[1]);
          int [][]  matrix = new int [n][m];
        int x = Integer.parseInt(v1[2]);
        int i =0;
         while(i>n){
       	 name = br.readLine(); 
         String [] v2 = name.split(" ");
         for(int j =0; j<m;j++){
         	matrix[i][j] = Integer.parseInt(v2[j]);
         }
         i++;
       }
       int columnMatrix [][] = new int [n][m];
       columnMatrix[0][0]
       for(int c =0; c<m;c++){
 				columnMatrix[0][c] = matrix[0][c]; 
       }
       for(int c=0;c<m;c++){
       	for(int r =1; r<n;r++){
       		columnMatrix[r][c] = columnMatrix[r-1][c] + matrix[r][c];
       	}
       }
	}
	catch(Exception e){
	
}
}

}