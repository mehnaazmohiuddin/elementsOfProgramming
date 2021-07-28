import java.util.*;

public class Overlap {
	public static void main (String [] args){
		Scanner s = new Scanner(System.in);
        String hhMM = s.nextLine();    
        //00:00 to hh.mm
        String time [] = hhMM.split(":");
        int endHour = Integer.parseInt(time[0]);
        int endMin = Integer.parseInt(time[1]);
        if(endHour == 0){
        	System.out.println("1");
        	return;
        }
        // lets calculate how many hours it took to make him sleep
        int numberOfTimesJoined = endHour;
        // lets check if the last one should be included in the overlap
        if(endHour>=12){
        	endHour = endHour-12;
        	numberOfTimesJoined--;
        }
        if(endHour == 12){
        	System.out.println("12");
        	return;
        }
        double meetingMin = ((double)endHour*30)/5.5;
     //   System.out.println("Meething min of 11 is"+meetingMin);
        if(endMin>=meetingMin){
        	numberOfTimesJoined++;
        }
        System.out.println(numberOfTimesJoined);



	}
}