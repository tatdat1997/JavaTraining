package java_core;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Demo_List {
	
	public static void main(String[] args) {
		List<String> newList = new ArrayList<String>();
		newList.add("A");
		newList.add("C");
		newList.add(1,"B");
		List<String> secondList = new ArrayList<String>();
		secondList.add("D");
		
		newList.addAll(2,secondList);

		newList.forEach(newLists->
		{
//			System.out.println(newLists);
		});
		newList.clear();
		 // Instantiate a Date object
	      Date date = new Date();

	      // display time and date using toString()
	      System.out.println(date.toString());
	      String str = String.format("Current Date/Time : %tc", date );
	      System.out.println(str);
	     
	      
	      SimpleDateFormat ft = 
	    	      new SimpleDateFormat ("yyyy/MM/dd");

	      System.out.println("Current Date: " + ft.format(date));
	      System.out.printf("%1$s %2$tD", "Due date:", date);
	}
}
