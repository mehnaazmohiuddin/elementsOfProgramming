import java.io.*;
import java.util.*;
class SayAndTell {

	String readString(String s){
		char [] string = s.toCharArray();
		int length = string.length;
		System.out.println("This is the length "+length);
		StringBuilder sb = new StringBuilder();
		int newStringPosition = 0;
		int oldStringPosition=0;
		int nextCharPosition =1;
		int counter = 1;
		char currentChar=string[0];
		while(nextCharPosition < length){
			if(currentChar == string[nextCharPosition]){
				counter++;
			}else{
				//time to append and write the count
				sb.append(counter);
				sb.append(currentChar);
				if(string[nextCharPosition]  == '\0'){
					// the end of the string has been reached.

				}else{
					currentChar = string[nextCharPosition];
					counter = 1;
				}
			}
			nextCharPosition++;
			if(nextCharPosition == length){
				sb.append(counter);
				sb.append(currentChar);
			}
		}

		
		return sb.toString();
	}
	public static void main(String [] args){
		int n = 8;
		String s = "11";

		SayAndTell sat = new SayAndTell();
		for (int i =3 ; i <=n; i++){
			s = sat.readString(s);
			System.out.println("This is the result string "+s);
		}
		System.out.println(s);

	}

}
