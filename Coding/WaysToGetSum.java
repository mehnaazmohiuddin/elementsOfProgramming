import java.io.*;
import java.util.*;

class WaysToGetSum {

    public static void main(String[] args) {
        // given an array of possible scores find in how many ways 
        //we can get the desired score.
        int[] scores = {
            2,
            3,
            7
        }; // assuming this is in order 
        int sum = 12;
        int numberOfScores = 3;
        // A[i][j] = the number of ways of making sum j incuding the ith score
        int[][] A = new int[numberOfScores][sum + 1];
        // to make sum 0, all have one way. 
        for (int r = 0; r < numberOfScores; r++) {
            A[r][0] = 1;
        }
        // handling impossible score
        for (int j = 1; j < scores[0]; j++) {
            for (int i = 0; i < numberOfScores; i++) {
                A[i][j] = 0;
            }
        }


        for (int i = 0; i <= sum; i++) {
            if (i % scores[0] == 0) {
                A[0][i] = 1;
            } else {
                A[0][i] = 0;
            }
        }


        //assuming the first row is filled .. will fill this row in a while
        int row = 1;
        int subSum = 1;
        for (row= 1; row<numberOfScores; row++) {
            for (subSum = 1; subSum <=sum; subSum++) {

                // if score itself is higher then 
                if (scores[row] > subSum)
                    A[row][subSum] = A[row - 1][subSum];
                // if the sum has something left in it or equal, then
                if ((subSum- scores[row]) >= 0)
                    A[row][subSum] = A[row - 1][subSum] + (A[row][subSum - scores[row]]);
               
            }
        }
        for (int r =0 ; r< numberOfScores; r++){
        	for(int j =0; j<=sum; j++){
        		System.out.print(","+A[r][j]);
        	}
 			System.out.println();
        }


        System.out.println("The number of ways to attain the sum of " + sum +  " is " + A[numberOfScores - 1][sum]);



    }


}