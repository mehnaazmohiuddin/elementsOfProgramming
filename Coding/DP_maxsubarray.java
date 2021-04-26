// Dynamic Programming 
// get the biggest subarray 

// I'm gonna calculate s[i] // where s[i] indicates the the biggest sum there is when s[i] is included... because we need to find a subarray so if we want to make s[i],s[i+1] part of that subarray we need to include A[i] element .. hence that is how we have decided our solution. that s[i] is the maximum subarray sum uptill and including a[i], therefore, Max(s[1..n])
//is the solution requested. 

import java.io.*;
import java.util.*;
class DP_maxsubarray {

	public static void main (String [] args){

		int a [] = {1,2,-1,11,4,3,-8,5,20,1};
		int global_max = Integer.MIN_VALUE;
		int s[] = new int [a.length];
		System.out.println("The size of Array a is "+a.length);
		s[0] = a[0];
		for (int i =1; i<a.length; i++){
			s[i] = Math.max(s[i-1]+a[i] , a[i]);
			System.out.println("The value of s["+i+"] is"+s[i]);
			if(s[i]> global_max){
				global_max = s[i];
			}
		}
		System.out.println(global_max);
	}
}