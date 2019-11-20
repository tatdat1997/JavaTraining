package java_core;

import java.util.*;

public class Demo_Vector {
	public static void main(String args[]) {
		  // capacity ban dau la 3, incr la 2
	      Vector<Integer> v = new Vector<Integer>();
	      v.add(1);
	      System.out.println("Size ban dau: " + v.size());
	      System.out.println("Capacity ban dau: " +
	      v.capacity());
	      v.add(2);
	      v.add(3);
	      v.add(4);
	      System.out.println("Capacity sau 4 lan cong la: " +
	          v.capacity());


	      System.out.println("Capacity hien tai: " +
	      v.capacity());
	      v.addElement(new Integer(7));
	      System.out.println("Capacity hien tai: " +
	      v.capacity());
	      v.addElement(new Integer(10));
	      System.out.println("Capacity hien tai: " +
	      v.capacity());
	      v.addElement(new Integer(11));
	      v.addElement(new Integer(12));
	      System.out.println("Phan tu dau tien: " +
	         (Integer)v.firstElement());
	      System.out.println("Phan tu cuoi cung: " +
	         (Integer)v.lastElement());
	      if(v.contains(new Integer(3)))
	         System.out.println("Vector chua 3.");
	      // tinh toan so phan tu trong vector.
	      Enumeration vEnum = v.elements();
	      System.out.println("\nCac phan tu trong Vector:");
	      while(vEnum.hasMoreElements())
	         System.out.print(vEnum.nextElement() + " ");
	      System.out.println();
	   }
}
