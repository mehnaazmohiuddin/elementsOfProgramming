import java.io.*;
import java.util.*;
// Be your experience, be humble. Be Kind it will follow. 
// Every Good deed will be rewareded -Allah
// Its amazing how you love to play with kids masood. WoW 
public class SubsetProblem {


	public static int minSubsetProblem (int [] x , int size, int value){
				//System.out.println(Arrays.toString(x));
				int count [][] = new int [size+1][value+1];
				for(int v=1;v<value+1;v++){
					count[0][v] = Integer.MAX_VALUE; //cant make it
				}
				count[0][0] = 1;
				for(int i=1;i<size+1;i++){
					count[i][0] = 0; //0 elements are required.
				}
				for(int i =1;i<=size;i++){
					int currentItem = x[i-1];
					for(int v = 1; v<=value;v++){
												if(currentItem == v){
							count[i][v] = 1;
						}else if (currentItem > v){
								count[i][v] = count[i-1][v];// whatver was previous
						}else {
								count[i][v] = Math.min((count [i-1][v-currentItem] == Integer.MAX_VALUE )?Integer.MAX_VALUE  :count[i-1][v-currentItem] + 1, count[i-1][v]);
							
						}
					}
				}
				
				return count[size][value];

	} 
	public static int countTheSubsets (int [] x, int size, int value){
		int count [][] = new int [size][value+1];
		for(int i =0;i<size;i++){
			count[i][0] = 1; //there is only one way to make 0 sum ;
		}
		for(int v = 1;v<=value;v++){
			if(x[0] == v){
				count[0][v]=1;
			}
			else
			count[0][v]=0;
		}
		//count[0][0]=1;
		//int tab[n + 1][sum + 1];
  // Initializing the first value of matrix
   
    for (int i = 1; i <= value; i++)
        count[0][i] = 0;
    for (int i = 1; i < size; i++)
        count[i][0] = 1;
	    count[0][0] = 1;
		for(int i =1; i<size;i++){
			for(int v = 1;v<=value;v++){
				int currentVal = x[i];
				if (v < currentVal){
					count[i][v] = count[i-1][v];
				}else if(v >= currentVal){ //greater..
					count[i][v] = count[i-1][v-currentVal] + count[i-1][v];
				}

			}
		}
		// for(int i =0; i<size;i++){
		// 	System.out.println(Arrays.toString(count[i]));
		// }
		return count[size-1][value];


	}



	public static boolean 	isSubsetPresent(int [] x,int size, int value){
		// no copies allowed.
		boolean s [][] = new boolean [size][value+1];
		// can we make 0 value ..false
		for(int i=0;i<value+1;i++){
			if(x[0] == i)
				s[0][i] = true;
			else
				s[0][i] = false;
		}

		for(int i=0;i<size;i++){
			s[i][0] = false; // shoudl this be true .. i think so ...
		}
		s[0][0] = true;
		for(int i =1;i<size;i++){
			for(int w = 1; w<value+1;w++){
				int currentValue = x[i];
				if(w < currentValue){
						s[i][w] = s[i-1][w];
				}else{
					// check 
					if(s[i-1][w] || s[i-1][w-currentValue]){
						s[i][w] = true;
					}else
						s[i][w] = false;
				}


			}
		}

		return s[size-1][value];


	}
	public static void main (String [] args){
		int [] currency = new int [] {5,5,5,6,2,7,3};
		boolean canMake = isSubsetPresent(currency,7,8);
		int numberOfSubset = countTheSubsets(currency,7,8);
		//	System.out.println(canMake);
		//	System.out.println(numberOfSubset);
			int num = minSubsetProblem(currency,7,8);
			System.out.println(num);

	}	



}