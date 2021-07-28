// LCS basically I got it. 	

import java.io.*;
import java.util.*;

class DP_longestCommonSubsequence{
	// solve it using recursion first. 
	// length of LCS
	//static Map<String, Integer> answer = new Map<String , Integer>();
	
	// static int LCS (String s1, String s2){
	// 	if(s1.length()*s2.length() == 0)
	// 		return 0;
	// 	String s1Cut = s1.substring(0,s1.length()-1);
	// 	String s2Cut = s2.substring(0,s2.length()-1);
	// 	if(s1.charAt(s1.length()-1) == s2.charAt(s2.length()-1))
	// 	{
	// 		String key = s1Cut.length()+"."+s2Cut.length();
	// 		Integer subLCS = answer.get(key);
	// 		int lcs = -1;
	// 		if(subLCS)
	// 		{
	// 			 lcs =  1 +subLCS; 
	// 		}
	// 		else {
	// 			lcs = LCS(s1Cut,s2Cut);
	// 			answer.put(key) = lcs;
	// 			lcs++;
	// 			return lcs;
	// 		}
	// 			answer.put(s1.length()+""+s2.length(), lcs);
	// 		return lcs;
	// 		}
	// 	else
	// 	{
	// 		if(answer.get(s1.length()+"."+s2Cut.length()))
	// 		LCS(s1,s2Cut)
	// 		return Math.max(, LCS(s1Cut,s2));

	// 	}
		

	// }

	public static void main(String [] args){
			String s1 = "AAAAAAA";
			String s2="AA"; 
			//System.out.println("The LCS of  "+s1+" and "+s2+"is of length"+LCS(s1,s2));
			int [][] lcs = new int [s1.length()+1][s2.length()+1];
			for (int c =0; c <s2.length()+1; c++){
				lcs[0][c]=0;
			}	
			for (int r =0; r<s1.length()+1; r++){
				lcs[r][0]=0;
			}	
			for (int r =1; r<s1.length()+1; r++){
					for (int c =1; c <s2.length()+1; c++){
							if(s1.charAt(r-1) == s2.charAt(c-1)){
								lcs[r][c] = 1+ lcs[r-1][c-1];
							}	
							else{
								lcs[r][c]=Math.max(lcs[r-1][c],lcs[r][c-1]);
							}
					}
			}
			System.out.println(lcs[s1.length()][s2.length()]);


	}

}