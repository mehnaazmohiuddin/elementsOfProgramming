

import java.util.LinkedList;
import java.util.*;

public class MinNumProductSum {

	public static int getProduct(int n) {
		int product = 1;

		while (n != 0) {
			product = product * (n % 10);
			n = n / 10;
		}

		return product;
	}

	public static int getSum(int n) {
		int sum;

		/* Single line that calculates sum */
		for (sum = 0; n > 0; sum += n % 10, n /= 10)
			;

		return sum;
	}

	public static void smallestNumber(int n) {
		if(n == 1) {
			System.out.print("1");
			return;
		}
//		int numbers = (int) Math.ceil(Math.log10(n) + (1 / Math.log10(n)));
		int numbers = (int) Math.ceil(Math.log10(n+1)) + 1;
		int fixedSum = n - numbers;

		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < numbers; i++) {
			sb.append(1);
		}
		int range = Integer.valueOf(sb.toString());
		int minNum = 0;
		for (int i = range; i <= range * 9; i++) {
			if(fixedSum + getSum(i) <= getProduct(i)) {
				minNum = i;
				break;
			}
		}
		
		for (int i = 1; i <= fixedSum ; i++) {
			System.out.print("1");
		}
		
		LinkedList<Integer> stack = new LinkedList<Integer>();
		while (minNum > 0) {
		    stack.push( minNum % 10 );
		    minNum = minNum / 10;
		}

		while (!stack.isEmpty()) {
		    System.out.print(stack.pop());
		}
		
	}

//Driver program to test above
	public static void main(String[] args) {
		//int n = 4;
		

		Scanner s = new Scanner(System.in);
        String testCases = s.nextLine();                 // Reading input from STDIN
       // System.out.println("Hi, " + name + ".");    // Writing output to STDOUT
		int test = Integer.parseInt(testCases);
		while(test!=0){
			String kString = s.nextLine(); 
			int k = Integer.parseInt(kString);
			smallestNumber(k);
			System.out.println();
			test--;
		}
	}
}
