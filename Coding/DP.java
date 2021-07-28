import java.util.*;
import java.io.*;

public class DP {

    // find the max fishes value. 

    public static void main(String[] args) {

        final int n = 5;
        final int m = 4;
        int valueMatrix[][] = new int[n][m];
        try {
            File file = new File("./testcases/DP_Matrix.txt");
            Scanner myReader = new Scanner(file);
            int i =0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String [] numbers = data.split(" ");
                int j =0;
                for(String num : numbers){
                	valueMatrix[i][j] = Integer.parseInt(num);
                	j++;
                }
                i++;
               
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        for (int i =0; i < n; i++){
        	for(int j =0; j<m;j++){
        		System.out.print(valueMatrix[i][j]+" ");
        	}
        	System.out.println();
        }

        int  [][] MaxSumMatrix = new int [n][m];
        MaxSumMatrix[0][0] = valueMatrix[0][0];
        for (int i =1;i<n;i++){
        	MaxSumMatrix[i][0]=valueMatrix[i][0]+MaxSumMatrix[i-1][0];
        }
        for (int j =1;j<m;j++){
        	MaxSumMatrix[0][j]=valueMatrix[0][j]+MaxSumMatrix[0][j-1];
        }
       for (int col = 1 ; col < m; col++){
       		for(int row = 1; row<n; row++){
       			System.out.println("Calculating for row,col "+row+" ,"+col);
       			MaxSumMatrix[row][col] = valueMatrix[row][col] + Math.max(MaxSumMatrix[row][col-1],MaxSumMatrix[row-1][col]);
       			System.out.println(" max value is "+MaxSumMatrix[row][col]);
       		}
       }

       for(int i =0; i< n; i++){
       	for(int j=0; j< m; j++){
       		 System.out.print(MaxSumMatrix[i][j] +" ");
       	}
       	System.out.println();
       }
       	
    }
}