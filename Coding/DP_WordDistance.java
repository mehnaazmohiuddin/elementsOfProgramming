// this will help us find the distance between words. 
class DP_WordDistance{
	
	public static int TR(String init, String finalS){
		if(init.length()*finalS.length() == 0){
			if(init.length() ==0)
				return finalS.length();
			else
				return init.length();
		}else
		{
			if(init.substring(init.length() - 1).equals(finalS.substring(finalS.length() - 1))) 
				return (  TR(init.substring(0, init.length() - 1),finalS.substring(0, finalS.length() - 1) ));
			else{
				String oneShort =  init.substring(0, init.length() - 1);
				String secondShort = finalS.substring(0, finalS.length() - 1) ;
				return 1 + Math.min(Math.min(TR(init,secondShort), TR(oneShort, finalS)), TR(oneShort,secondShort));
			}

		}
	}

	public static void main (String []args)
	{
		String one = "Carthorse";
		String two = "Orchestra";
		int distance = TR(one,two);
		System.out.println("The distance between"+ one +" and "+two+" is"+distance);
	}

}