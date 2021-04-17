// compute all valid ips 

import java.io.*;
import java.util.*;

class IP{
	static boolean isValid(String shortIp){
		//System.out.println("This is the shortIp "+shortIp);
		int value = Integer.parseInt(shortIp);
		System.out.println("hello");
		//System.out.println("This is the shortIp "+shortIp +" its value is"+value);
		if( value>255 || ((shortIp.startsWith("0") || shortIp.startsWith("00"))&& value > 0) || shortIp.startsWith("00") || shortIp.startsWith("000") ){
			return false;
		}else 
		return true;
	}
	public static void main(String [] args){
		String ip = "88888888";
		String firstIp = "", secondIp="", thridIp ="", fourthIp="";
		int fd,sd,td;
		int length = ip.length();
		if(length > 12 || length < 4){
			System.out.println("Invalid");
			return;
		}
		for( fd = 1; fd <= 3;  fd++){
			 firstIp = ip.substring(0,fd);
			if(isValid(firstIp)){
				//127.0.0.1 
				for(sd = fd+1; sd<= fd+3  && sd<length; sd++){
					secondIp = ip.substring(fd,sd);
					if(isValid(secondIp)){
						for( td = sd+1; td<= sd+3 && td<length ; td++){
							 thridIp = ip.substring(sd,td);

							if(isValid(thridIp)){
								fourthIp = ip.substring(td,length);
								if(isValid(thridIp)&& isValid(fourthIp) ){
								//System.out.println("Valid IP here");

									System.out.println(firstIp+"."+secondIp+"."+thridIp+"."+fourthIp);
								}
							}
						}
					}	
			}
		}

	}
}
}
