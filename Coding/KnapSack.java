import java.io.*;
import java.util.*;

public class KnapSack {
	

	public static  void findTheItems (int [] W, int []V,int size,  int cap){
		System.out.println(Arrays.toString(W));
		System.out.println(Arrays.toString(V));
		System.out.println(size);
		System.out.println(cap);


		//ArrayList<Integer> important = new ArrayList<Integer>();
		int A[][] = new int [size][cap+1];
		for(int capacityNow=1; capacityNow<=cap;capacityNow++){
			if(capacityNow<W[0])
			A[0][capacityNow] =0;
			else if (capacityNow >=W[0]){ // 
				A[0][capacityNow] = V[0];// keep tht value.
			}
		}
		System.out.println(Arrays.toString(A[0]));
		
		// for the rest of the items it will be the max of ... if we chose to leave it .. if we chose to keep it 
		for (int i =1; i<size;i++){
			for(int capacity =1; capacity <=cap;capacity++){
				if(W[i]>capacity){
					A[i][capacity] = A[i-1][capacity];
				}else{
					// if we can add that weight. //then it must be the max of 
					//System.out.println(A[i-1][capacity] +"checking ,,"+A[i-1][capacity-W[i]] + V[i]);
					A[i][capacity] =Math.max (A[i-1][capacity], A[i-1][capacity-W[i]] + V[i]);
				}
			}
			System.out.println(Arrays.toString(A[i]));
		}
		System.out.println("The max value that can be got is"+A[size-1][cap]);
		// final answer is the value that will be in the knap sack and not what all items did u get. 
		 

	}
	public static void main(String [] args){
		int [] W = {3,4,2,5,5};
		int [] V = {10,13,1,6,6};
		int maxCap = 7;
		findTheItems(W,V,5,maxCap);
	}
}
