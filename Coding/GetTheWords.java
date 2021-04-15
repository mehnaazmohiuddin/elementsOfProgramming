import java.io.*;
import java.util.*;
public class GetTheWords {

	private HashMap<String,String[]> numberToAlpha;

	public GetTheWords(){
		this.numberToAlpha = new HashMap<String,String[]>();
		String [] a = {"A","B","C"};
		String [] b = {"d","e","f"};
		String [] c = {"g","h","i"};
		String [] d = {"j","k","l"};
		String [] e = {"m","n","o"};
		String [] f = {"p","q","r"};
		String [] g = {"s","t","u"};
		String [] h = {"v","w","x"};
		String [] i = {"y","z"};

		numberToAlpha.put("1",a);
		numberToAlpha.put("2", b);
		numberToAlpha.put("3", c);
		numberToAlpha.put("4", d);
		numberToAlpha.put("5", e);
		numberToAlpha.put("6", f);
		numberToAlpha.put("7", g);
		numberToAlpha.put("8", h);
		numberToAlpha.put("9", i);
	//	numberToAlpha.put("9", new String[] ("Z"));

	}

	 LinkedList<String> getWord(String number){
		if(number.length() == 0 ){
			return new LinkedList<String>();
		}
		if(number.length() == 1){
			List<String> list = Arrays.asList(numberToAlpha.get(number));
			return new LinkedList<String>(list);
		
		}else{
			LinkedList<String> endings=getWord(number.charAt(number.length()-1)+"");
			System.out.println("This is the length of the number"+ number.length());
			LinkedList<String> startings =getWord(number.substring(0, number.length()-1));
			LinkedList<String> finals = new LinkedList<String>();
			for(String s : startings){
				for (String e : endings){
					finals.add(s+e);
				}
				
			}
		return finals;
		
		}
	
	}
        public static void main (String [] args)
	{

		String input = "155";
		GetTheWords gtw = new GetTheWords ();
		LinkedList<String> finalAns = gtw.getWord(input);
		System.out.println(finalAns);

	}

}
