import java.io.*;
import java.util.*;
class KnapSackFractional {
	
	public static float fullProfit(int W[], int V[], int size, float cap){
		float [] ratio  = new float [size];
		for(int i=0;i<size; i++){
			ratio[i] = V[i]/W[i];
		}
		//float [] ratioSorted= Array.sort(ratio);
		// pick the best then see if any left
		//treeMap
		TreeMap<Float, ArrayList<Integer>> tmap = new TreeMap <Float, ArrayList<Integer>>( Collections.reverseOrder() );
		for(int i =0; i<size;i++){
			if(tmap.containsKey(ratio[i])){
				ArrayList<Integer> l =tmap.get(ratio[i]);
				l.add(i);
			}else{
					ArrayList<Integer> al = new ArrayList<Integer>();
					al.add(i);
					tmap.put(ratio[i],al);


			}
		
		}
		
  		float value = 0;
  		System.out.println("Size of map is"+tmap.size());
  		for (Map.Entry<Float, ArrayList<Integer>>
                 entry : tmap.entrySet())
        {
			System.out.println("Ration to index"+entry.getKey()+","+entry.getValue());
        }
        // Traverse map and print elements
        for (Map.Entry<Float, ArrayList<Integer>>
                 entry : tmap.entrySet())
        {
        	 
        	ArrayList<Integer> indexs = entry.getValue();
        	 System.out.println("The best P/W is index"+indexs);
        	 for(int i : indexs){
	        	 	if(cap >= W[i]){

	          		cap = cap- W[i];
	          		value += V[i];
	          		System.out.println("We are taking index"+i);
	          	}else if(cap >0){
	          		value+=(W[i]/cap)*V[i];
	          		System.out.println("We are taking index"+i);

	          		cap = 0;
	          		
	          	}
          }
          
        }
        return value;

	}

	public static void main (String args[]){
		int W [] = {2,3,5,7,1,4,1};
		int P [] = {10,5,15,7,6,18,3};
		float profit = fullProfit(W,P, 7, 15 );
		System.out.println(profit);
	}
}