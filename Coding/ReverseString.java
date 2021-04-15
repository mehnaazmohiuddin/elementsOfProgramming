import java.io.*;
import java.util.*;
public class ReverseString {


	public static void main (String [] args) 
	{
		Scanner sc= new Scanner(System.in); 
		String sentence = sc.nextLine();
		System.out.println("the Line you wrote is "+ sentence);
		String []words = sentence.split(" ");
		StringBuilder sb = new StringBuilder();
		System.out.println(words.length+"this is my length");
		for (int i = words.length-1; i>=0;i--){
			sb.append(words[i]);
			sb.append(" ");
			
		}
		sb.deleteCharAt(sb.length()-1);

		System.out.println("the Reverse is "+sb);
	}


}
