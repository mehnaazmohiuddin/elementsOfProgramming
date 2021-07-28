import java.util.*;


public class BinaryPalindrome{


	public static String StringBinary (int x){
		StringBuilder sb = new StringBuilder();
		while(x >0 ){
			if(x%2==0){
				sb.insert(0,0);
			}else{
				sb.insert(0,1);
			}
			x=x/2;
		}
		return sb.toString();

	}
	public static boolean isPalindrome(String s){
		char [] chrs = s.toCharArray();
		int length = chrs.length;
		for(int i =0, j = length-1 ; i<j; i++,j--){
			if(chrs[i]!=chrs[j]){
				return false;
			}
		}
		return true;
	} 
	
	public static int getSmallestNumber(String binaryString ){

			int n=Integer.parseInt(binaryString,2);
			//	System.out.println("Got the integer as"+n);
			if(isPalindrome(binaryString)){
				return 0;
			}else{
				int length = binaryString.length();
				String half = binaryString.substring(0,length/2);
				StringBuilder sb = new StringBuilder(half);
				char [] chalf = half.toCharArray();
				if(length%2 != 0)
					sb.append(binaryString.charAt(length/2));
				for(int i = chalf.length-1; i >=0; i--){
						sb.append(chalf[i]);
					}
					int minPalindrome = Integer.parseInt(sb.toString()	, 2);
					int value=	n - minPalindrome;
					return  value < 0? value*-1 : value;

			}
			
	}
	public static int refine (int n, int delta){
		if(n%2 == 0){
			// add only odd numbers
			 for(int i =1 ; i<=delta; i+=2){
		 	if(isPalindrome(Integer.toBinaryString(n+i)))
		 		return i;
		 	if(isPalindrome(Integer.toBinaryString(n-i)))
		 		return i;
		 }
		}
		else{
		 for(int i =2 ; i<=delta; i+=2){
		 	if(isPalindrome(Integer.toBinaryString(n+i)))
		 		return i;
		 	if(isPalindrome(Integer.toBinaryString(n-i)))
		 		return i;
		 }
		}
		 return 0;
	}
	
	public static void main (String []args){
		Scanner s = new Scanner(System.in);
        int testCases = Integer.parseInt(s.nextLine()); 

        while(testCases>0){
        	String number =  s.nextLine();
        	int n = Integer.parseInt(number);
        	int possibleAns = getSmallestNumber(Integer.toBinaryString(n));
        	int refine = refine(n,possibleAns);


        	//System.out.println("Possible ans from first tech"+ possibleAns);
        	//System.out.println("Possible ans from second tech "+ refine2(n));
        	System.out.println(refine<possibleAns?refine:possibleAns);
        	
        	testCases--;
        }



	}
}