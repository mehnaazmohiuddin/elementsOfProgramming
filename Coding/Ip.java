// compute all valid ips 

import java.io.*;
import java.util.*;

class IP{
	ipIsValid(String shortIp){
		System.out.println("This is the shortIp "+shortIp);
		int value = Integer.parseInt(shortIp);
		if((shortIp.startWith("0")&& value>0 )|| Integer.parseInt(shortIp)>255){
			return false;
		}else 
		return true;
	}
	public static void main(Strings [] args){
		String ip = "192168290";

		int length = ip.length();
		for(int fd = 1; fd <= length -3;  fd++){
			String firstIp = ip.subString(0,fd);
			if(isValid(firstIp)){
				for( int sd = fd+1; sd<= length -2 ; sd++)
					String secondIp = ip.subString(fd,sd);
					if(isValid()){
						for(int td = sd+1; td<= length -1 ; td++){
							String thridIp = ip.subString(sd,td);
							if(isValid(thridIp)){
								System.out.println(firstIp+"."+secondIp+"."+thridIp);
							}
						}
					}	
			}
		}

	}
}