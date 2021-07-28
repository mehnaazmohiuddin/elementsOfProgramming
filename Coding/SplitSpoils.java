import java.io.*;
import java.util.*;

public class SplitSpoils {
	public static int splitSpoils ( int [] w, int [] v, int size, int halfCap){
			int A[][] = new A[size+1][halfCap+1];
			char S[][] = new S[size+1][halfCap+1];
			for (int i =0; i<=size;i++){
				A[i][0] =0; // 
			}
			for(int i=0;i<=halfCap;i++){
				if(w[0]<i){
					A[1][i] =0;
					S[1][i] = '0';
				}else{
					A[1][i] = v[0];
					S[1][i] = 'Y';
				}
			}
			for(int items = 2;i<size;i++){
				for(int weight = 1; weight<= halfCap; weight++){
					if(w[item] >weight){
						A[item][weight] = A[item-1][weight];
						S[1][i] = 'N';
					}else{
						// shall we select it or not 
						
							S[item][weight] = A[item -1][weight] > A[item-1][weight-w[item-1]]+v[item-1] ?  'N' : 'Y';
						    A[item][weight] = Math.max(A[item -1][weight],A[item-1][weight-w[item-1]]+v[item-1]);
					}
				}
			}
			for(int i =1 ; i <=size;i++){
				for(int we = 1; we<=halfCap ; we++)
			}
	}
	public static void main (String [] args){

	}
}