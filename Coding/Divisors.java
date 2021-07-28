import java.io.*;
import java.util.*;

public class Divisors {
	public static boolean isSquareFree (int num){
		for(int i =2; i<= num/2;i++){
			if(num%i ==0 && num%(i*i) == 0){
				return false;
			}
		}
		return true;
	}
	public static ArrayList calSFDivisors (int num){
		ArrayList<Integer> sFdivisors = new ArrayList<Integer>();
		for(int i =2; i<= num/2;i++){

			if( num%i == 0 && isSquareFree(i) ){
					sFdivisors.add(i);
			}
		}
		if(isSquareFree(num)){
			sFdivisors.add(num);
		}
		return sFdivisors;
	}



	public static void main (String [] args){
		int  [] A = {2,3,5,6,7,8,12,15,9};

		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int j =0; j<A.length; j++){
			ArrayList<Integer> al = calSFDivisors(A[j]);
			for(Integer i : al){
				int key = i;
				if(map.containsKey(key)){
					int count = map.get(key);
					map.replace(key,count+1);
				}else{
					map.put(key,1);
				}

			}

			// we will get the list of sfdivisors now we need to find which one divides the most. 
		}
		int sizeP = 0;
		for (Map.Entry<Integer,Integer> entry : map.entrySet())
            {
            	int numberOfItemsThatAreDivisibleNow = entry.getValue();
            	// System.out.println("Key = " + entry.getKey() +
             //                 ", Value = " + entry.getValue());
            		if(sizeP < numberOfItemsThatAreDivisibleNow){
            			sizeP = numberOfItemsThatAreDivisibleNow;
            		}

            }
            System.out.println("The P value is"+sizeP);
	}
}